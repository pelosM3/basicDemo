package es.horus.altamira.basic.demo.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import es.horus.altamira.basic.demo.common.DataSource;
import es.horus.altamira.basic.demo.common.UtilsUI;
import es.horus.altamira.basic.demo.login.AccessControl;

@CssImport("./styles/shared-styles.css")
@CssImport(value="./styles/grid-styles.css", themeFor = "vaadin-grid")
@CssImport(value="./styles/dialog-styles.css", themeFor = "vaadin-dialog-overlay")
@CssImport(value="./styles/button-styles.css", themeFor = "vaadin-button")
@CssImport(value="./styles/common-styles.css", themeFor = "*")
@CssImport(value="./styles/menu-bar-styles.css", themeFor = "vaadin-menu-bar")
public class MainLayout extends VerticalLayout {
	
	private String fechaActual;
	
	public MainLayout() {
		setSizeFull();
		
		addAttachListener(e->build());
	}
	
	private void build() {
		removeAll();
		// Datos de sesion
		add("Datos de sesión");
		add(new VerticalLayout(new Span("Usuario: " + AccessControl.getInstance().getUserLogin()),
				new Span("Fecha: " + AccessControl.getInstance().getFechaLogin())));
		// Datos estaticos
		add(new Hr());
		add("Dato estático");
		add(new VerticalLayout(new Span(DataSource.getData())));
		// Texfield
		add(new Hr());
		TextField textField = new TextField("Campo de texto iniciado con el dato estático");
		textField.setWidthFull();
		textField.setValue(DataSource.getData());
		add(textField);
		// Boton
		add(new Hr());
		fechaActual = UtilsUI.hoyFormateado();
		Button button = new Button("Botón");
		button.addClickListener(e->{
			VerticalLayout digLay = new VerticalLayout();
			digLay.setPadding(false);
			digLay.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
			Dialog dialog = new Dialog(digLay);
			digLay.add(new Span("Botón pulsado: "+UtilsUI.hoyFormateado()),
					new Span("Botón creado: "+fechaActual),
					new Button("Cerrar", ev->dialog.close()));
			dialog.open();
		});
		add(button);
	}
	
}


