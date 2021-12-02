package es.horus.altamira.basic.demo.conf.error;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.DefaultErrorHandler;
import com.vaadin.flow.server.ErrorEvent;
import com.vaadin.flow.server.ErrorHandler;

import es.horus.altamira.basic.demo.common.ConstantsUI;
import es.horus.altamira.basic.demo.common.UtilsUI;

public class MainErrorHandler implements ErrorHandler {
	
	/**
	 * Muestra al usuario un error de Vaadin y lo registra en el log
	 * @param e 
	 */
	public static void handleError(Throwable e) {
		new MainErrorHandler().error(new ErrorEvent(e));
	}

	@Override
	public void error(ErrorEvent throwable) {
		Throwable t = error(throwable.getThrowable());

		showErrorMsg(t);
	}

	private void showErrorMsg(Throwable t) {
		if (UI.getCurrent() == null) {
			// Si no hay una UI activa no mostramos mensaje
			return;
		}
		
		Dialog notification = new Dialog();
		UtilsUI.addTheme(notification, ConstantsUI.TEMA_DIALOGO_ERROR);

		Button cerrar = new Button("Cerrar", VaadinIcon.CLOSE.create(), e -> notification.close());
		Button masInf = new Button(VaadinIcon.INFO.create());
		masInf.setText("Mas inf");
		
		HorizontalLayout layout = new HorizontalLayout();
		layout.add(new Span("Error"), cerrar, masInf);
		layout.expand(layout.getComponentAt(0));
		layout.setMinWidth("500px");
		layout.setAlignItems(Alignment.CENTER);
		notification.add(layout);
		notification.open();
		
		masInf.addClickListener(e-> {
			Checkbox checkMostrarTrazaCompleta = new Checkbox("Traza completa");
			layout.replace(masInf, checkMostrarTrazaCompleta);
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			t.printStackTrace(new PrintStream(os));
			String excTxt = os.toString();
			// Quitamos lineas superfluas
			StringBuilder sb = new StringBuilder();
			List<String> subtrazas = new ArrayList<>();
			for (String linea : excTxt.split("\\R+")) {
				if (!linea.startsWith("\tat")) {
					if (!subtrazas.isEmpty()) {
						sb.append("\t... " + subtrazas.size() + " trazas no relevantes").append("\n");
					}
					subtrazas.clear();
					sb.append(linea).append("\n");
				} else if (linea.startsWith("\tat es.")) {
					if (!subtrazas.isEmpty()) {
						sb.append(StringUtils.join(subtrazas, "\n")).append("\n");
						subtrazas.clear();
					}
					sb.append(linea).append("\n");
				} else {
					subtrazas.add(linea);
				}
			}
			
			Span textarea = new Span(sb.toString());
			textarea.setWidthFull();
			textarea.getStyle().set("white-space", " pre");
			VerticalLayout scroll = new VerticalLayout(textarea);
			scroll.getStyle().set("overflow-y", "auto");
			scroll.getStyle().set("overflow-x", "hidden");
			scroll.getStyle().set("background-color", "#db403d");
			scroll.getStyle().set("color", "white");
			scroll.setMaxHeight("500px");
			scroll.setMaxWidth("1000px");
			notification.add(scroll);
			
			checkMostrarTrazaCompleta.addValueChangeListener(ev->textarea.setText(ev.getValue() ? excTxt : sb.toString()));
		});
	}

	/**
	 * Registra el error en el log
	 * @param error
	 * @return el error que se registro
	 */
	public static Throwable error(Throwable error) {
		Throwable t = DefaultErrorHandler.findRelevantThrowable(error);

		t.printStackTrace();
		
		return t;
	}
	
	public static void handleError(Exception e, Optional<UI> ui) {
		new MainErrorHandler().error(new ErrorEvent(e), ui);
	}

	public void error(ErrorEvent throwable, Optional<UI> uiOpt) {
		Throwable t = error(throwable.getThrowable());
		UtilsUI.accessUI(uiOpt, ()->showErrorMsg(t));
	}
}
