package es.horus.altamira.basic.demo.common;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.KeyPressEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.server.Command;
import com.vaadin.flow.server.InputStreamFactory;
import com.vaadin.flow.server.StreamResource;

public class UtilsUI {
	

	public final static String IMAGE_COVID19_POSITIVO = "images/iconos/covid19_v2.png";
	public final static String IMAGE_COVID19_NEGATIVO = "images/iconos/covid19_nega.png";
	public final static String IMAGE_COVID19_PROBABLE = "images/iconos/covid19_prob.png";
	public final static String IMAGE_COVID19_SIN = "images/iconos/covid19_sin.png";
	public final static String IMAGE_COVID19_ANTIGUO = "images/iconos/covid19_antiguo.png";
	public final static String IMAGE_COVID19_CAMA_COVID = "images/iconos/covid19_cama_covid.png";
	public final static String IMAGE_SESION_ONC = "images/iconos/sesiononc.png";
	public final static String IMAGE_ENSAYO = "images/iconos/ensayo.png";
	public final static String IMAGE_MASCARILLA = "images/iconos/mascarilla.png";
	
	public final static String IMAGE_VIRAS_PEQ = "images/iconos/viras-peq.png";
	public final static String IMAGE_VIRAS_PEQ_D = "images/iconos/viras-peq-d.png";

	public final static String IMAGE_PFP = "images/iconos/Pfp.png";
	
	public final static String IMAGE_ALERTAS = "images/iconos/alergias_aviso.png";
	public final static String IMAGE_ALERGIAS = "images/iconos/alertas_peq.png";
	
	public final static String IMAGE_BOTON_RESTRICCION =  "images/iconos/buttonRestriccion.png";
	public final static String IMAGE_BOTON_RESTRICCION_ACTIVA = "images/iconos/buttonRestriccion1.png";
	
	public final static String IMAGE_MADRE_CON_BEBE= "images/iconos/madre_con_bebe.png";

	
	public final static String IMAGE_ALERTA_ANONIMO = "images/iconos/alerta-anonimo2.png";
	
	public final static String IMAGE_FAVORITO = "images/iconos/favorito.png";
	public final static String IMAGE_NO_FAVORITO = "images/iconos/favorito_no.png";
	
	public final static String IMAGE_RESUMEN_PACIENTE = "images/iconos/detalle_paciente.png";
	
	public final static String IMAGE_NOTAS = "images/iconos/notas.png";
	
	public final static String IMAGE_EXPORT_HISTORIA = "images/iconos/aptoncd.png";

	public final static String IMAGE_ADD_PROCESO = "images/iconos/cog_add.png";

	public final static String IMAGE_BTN_RAINBOW = "images/iconos/rainbow-16px.jpg";
	
	public final static String IMAGE_BTN_RELOAD =  "images/iconos/reload-small.png";


	/**
	 * Crea un icono de Vaadin con el color indicado
	 * @param vIcon icono de vaadin
	 * @param color
	 * @return instancia del icono
	 */
	public static Icon icon(VaadinIcon vaadinIcon, String color) {
		Icon icon = vaadinIcon.create();
		icon.setColor(color);
		return icon;
	}
	
	/**
	 * Crea un icono de Vaadin con el color indicado
	 * @param vIcon icono de vaadin
	 * @param color
	 * @param size 
	 * @return instancia del icono
	 */
	public static Icon icon(VaadinIcon vaadinIcon, String color, String size) {
		Icon icon = vaadinIcon.create();
		icon.setColor(color);
		icon.setSize(size);
		return icon;
	}
	
	/**
	 * Muestra una notificacion con un boton de cerrar
	 * @param text texto de la notificacion
	 * @return
	 */
	public static Dialog notification(String text) {
		Dialog dialog = new Dialog();
		Button cerrar = new Button("Cerrar", VaadinIcon.CLOSE.create(), e->dialog.close());
		Span span = new Span(text);
		span.setWidth("max-content");
		VerticalLayout layout = new VerticalLayout(span, cerrar);
		layout.setPadding(false);
		layout.setAlignSelf(Alignment.CENTER, cerrar);
		dialog.add(layout);
		dialog.open();
		return dialog;
	}
	
	/**
	 * Muestra un mensaje de error con un boton de cerrar
	 * @param text texto del error
	 * @return
	 */
	public static Dialog error(String text) {
		Dialog dialog = new Dialog();
		addTheme(dialog, ConstantsUI.TEMA_DIALOGO_ERROR);

		Button cerrar = new Button("Cerrar", VaadinIcon.CLOSE.create(), e -> dialog.close());
		cerrar.setMinWidth("min-content");
		
		HorizontalLayout layout = new HorizontalLayout();
		Span textarea = new Span(text);
		textarea.getStyle().set("white-space", " pre");
		layout.add(textarea, cerrar);
		layout.expand(layout.getComponentAt(0));
		layout.setMinWidth("500px");
		layout.setAlignItems(Alignment.CENTER);
		dialog.add(layout);
		dialog.open();
		return dialog;
	}
	
	/**
	 * Crear y muestra un dialogo de confirmacion: un texto, un boton de aceptar y otro de cancelar
	 * @param text texto a mostrar en el dialogo
	 * @param onConfirm accion que se ejecutara al configurar, pulsar el boton de aceptar
	 * @return
	 */
	public static Dialog confirmDialog(String text, ComponentEventListener<ClickEvent<Button>> onConfirm) {
		Dialog dialog = new Dialog();
		Button aceptar = new Button("Aceptar", UtilsUI.icon(VaadinIcon.CHECK, "green"), e->{onConfirm.onComponentEvent(e);dialog.close();});
		Button cancelar = new Button("Cancelar", UtilsUI.icon(VaadinIcon.CLOSE, "red"), e->dialog.close());
		aceptar.getStyle().set("margin-left", "var(--lumo-space-m)");
		Span msg = new Span(text);
		msg.getElement().getStyle().set("padding-right", "5px");
		dialog.add(msg, cancelar, aceptar);
		dialog.open();
		return dialog;
	}
	
	/**
	 * Crear un boton para descargar un fichero
	 * 
	 * @param button      boton que se mostrara
	 * @param fileName    nombre del fichero a descargar
	 * @param inputStream factoria que debe crear un {@link InputStream} que
	 *                    contenga los datos a descargar
	 * @param nuevaVentana si el fichero que se descargue se tiene que ver en una nueva ventana/pestaña del navegador
	 * @return componente de Vaadin que permitira descargar un fichero
	 */
	public static Anchor download(Button button, String fileName, InputStreamFactory inputStream, boolean nuevaVentana) {
		Anchor download = new Anchor();
		download.setHref(new StreamResource(fileName, inputStream));
		download.add(button);
		if (nuevaVentana) {
			download.setTarget("_blank");
		}else {
			download.getElement().setAttribute("download",true);
		}
		return download;
	}
	
	/**
	 * Crear un boton para descargar un fichero a traves de URL
	 * 
	 * @param button      boton que se mostrara
	 * @param url    URL del fichero
	 * @param nuevaVentana si el fichero que se descargue se tiene que ver en una nueva ventana/pestaña del navegador
	 * @return componente de Vaadin que permitira descargar un fichero
	 */
	public static Anchor download(Button button, String url, boolean nuevaVentana) {
		Anchor download = new Anchor();
		download.setHref(url);
		download.add(button);
		if (nuevaVentana) {
			download.setTarget("_blank");
		}else {
			download.getElement().setAttribute("download",true);
		}
		return download;
	}
	
	/**
	 * Abre una ventana/pestaña nueva en el navegador para acceder a la URL indicada
	 * 
	 * @param url URL a abrir
	 */
	public static void openURL(String url) {
		UI.getCurrent().getPage().executeJs("window.open('"+url+"', '_blank');");
	}
	
	/**
	 * Hace que el componente y todos los que contenga (si es un contenedor) sean de solo lectura de forma recursiva.
	 * @param component componente que se pondra como solo lectura
	 */
	public static void readOnly(Component component, boolean readOnly) {
		if (component instanceof HasValueAndElement) {
			((HasValueAndElement<?,?>)component).setReadOnly(readOnly);
		}
		component.getChildren().forEach(child->readOnly(child, readOnly));
	}
	
	/**
	 * Fija un tooltip html (atributo title) para el componente indicado
	 * @param component componente al que se pondra el tooltip
	 * @param tooltip texto del tooltip
	 * @return el mismo componente al que se le ha puesto el tooltip
	 */
	public static <T extends Component> T tooltip(T component, String tooltip) {
		if (tooltip != null) {
			component.getElement().setAttribute("title", tooltip);
		}
		return component;
	}
	
	public static Component iconoNotificacion(String urlImg, String txt,String hSize,String wSize) {
		Image img = new Image(urlImg, txt);
		Span span = new Span(txt);
		span.getStyle().set("margin-left", "2px");
		span.getStyle().set("font-size", "small");
		img.setHeight(hSize);
		img.setWidth(wSize);
		Div div = new Div(img, span);
		return div;
	}
	
	/**
	 * Crea un componente con un icono y un pequeño texto adjunto
	 * @param urlImg url de la imagen del icono
	 * @param txt texto
	 * @return componente
	 */
	public static Component iconoNotificacion(String urlImg, String txt) {
		Image img = new Image(urlImg, txt);
		Span span = new Span(txt);
		span.getStyle().set("margin-left", "2px");
		span.getStyle().set("font-size", "small");
		Div div = new Div(img, span);
		return div;
	}
	
	public static Span textoColor(String txt, String tooltip, String backgroundcolor, String textcolor) {
		Span span = new Span();
		if (txt != null) {
			span.setText(txt);
		}
		tooltip(span, tooltip);
		
		if (backgroundcolor != null) {
			span.getStyle().set("background-color",backgroundcolor);
		}
		span.getStyle().set("padding", "0 10px");
		span.getStyle().set("border-radius", "10px");
		
		if (textcolor != null) {
			span.getStyle().set("color",textcolor);
		}
		return span;
	}
	
	public static <T> Collection<T> obtenerLista(ComboBox<T> combo){
		return ((ListDataProvider<T>) combo.getDataProvider()).getItems();
	}
	
	public static <T extends HasStyle> T negrita(T component) {
		component.getStyle().set("font-weight", "bold");
		return component;
	}
	
	public static <T extends HasStyle> T paddingRight(T component) {
		component.getStyle().set("padding-right", "var(--lumo-space-m)");
		return component;
	}
	
	public static <T extends HasStyle> T paddingLeftRight(T component) {
		component.getStyle().set("padding", "0 var(--lumo-space-m)");
		return component;
	}
	
	public static <T extends KeyNotifier> T onEnter(T component, ComponentEventListener<KeyPressEvent> listener) {
		component.addKeyPressListener(Key.ENTER, listener);
		return component;
	}
	
	public static Span buildTabText(String txt) {
		Span span = new Span(txt);
		span.getStyle().set("margin-left", "25px");
		return span;
	}
	
	public static void accessUI(Optional<UI> optUI, Command command) {
		optUI.ifPresent(ui->ui.access(command));
	}
	
	public static <T> void gridResizable(Grid<T> grid,boolean resize) {
		//Columnas resizables
        for(Column<T> c:grid.getColumns()) {
        	c.setResizable(resize);
        }
	}
	
	public static <T extends Component> T addTheme(T element, String theme) {
		element.getElement().getThemeList().add(theme);
		return element;
	}
	
	public static <T, U extends HasValue<?,T>> U setValueReadOnly(U readOnlyComponent, T value) {
		readOnlyComponent.setReadOnly(false);
		readOnlyComponent.setValue(value);
		readOnlyComponent.setReadOnly(true);
		return readOnlyComponent;
	}

	public static String hoyFormateado() {
		return new SimpleDateFormat("dd/MM/yyy HH:mm:ss").format(new Date());
	}
}
