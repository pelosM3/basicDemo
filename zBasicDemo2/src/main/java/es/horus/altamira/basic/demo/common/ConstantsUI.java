package es.horus.altamira.basic.demo.common;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.VaadinIcon;

public class ConstantsUI {
	/**
	 * Dialogo de error (fondo rojo)
	 */
	public static final String TEMA_DIALOGO_ERROR = "error";
	/**
	 * Dialogo sin margenes
	 */
	public static final String TEMA_DIALOGO_SIN_BORDES = "no-border-dialog";
	/**
	 * Dialogo a pantalla completa
	 */
	public static final String TEMA_DIALOGO_PANTALLA_COMPLETA = "full-screen-dialog";
	/**
	 * Dialogo a que ocupa media pantalla
	 */
	public static final String TEMA_DIALOGO_MEDIA_PANTALLA = "half-screen-dialog";
	/**
	 * Estilo para añadir a un contenedor un borde
	 */
	public static final String ESTILO_CAJA_BORDE = "caja-borde";
	/**
	 * Pestañas con bordes
	 */
	public static final String ESTILO_TAB_BORDE = "tab-borde";
	
	/**
	 * Estilo para mostrar un texto como etiqueta: con border redondeados y margen
	 * horizontal. Pensado para usarlo junto con un estilo de color de fondo
	 */
	public static final String ESTILO_ETIQUETA = "etiqueta";
	
	/**
	 * Estilo para un menu desplegable al hacer click en un boton
	 */
	public static final String ESTILO_MENU_DESPLEGABLE = "menu-desplegable";
	/**
	 * Estilo añadir margenes a un menu desplegable al hacer click en un boton
	 */
	public static final String ESTILO_MENU_DESPLEGABLE_MARGEN = "menu-desplegable-margen";
	
	/**
	 * menu bar con un color que resalte
	 */
	public static final String ESTILO_MENU_BAR_DESTACADO = "menu-bar-destacado";
	/**
	 * Estilo para que las filas de una tabla no tengan espacio entre si
	 */
	public static final String ESTILO_GRID_SIN_ESPACIOS = "grid-no-padding";

	
	/**
	 * Estilo para componente personalizado de pestañas que se pueden cerrar
	 */
	public static final String ESTILO_PESTANAS_CERRABLES = "pestanas-cerrables";
	public static final String ESTILO_PESTANA_CERRABLE = "pestana-cerrable";
	public static final String ESTILO_PESTANA_CERRABLE_BOTON = "pestana-cerrable-boton";
	
	/**
	 * Estilo para botones que se adapten al tamaño de la pantalla: si la pantalla es demasiado pequeña, no se muestra el texto del boton, solo es icono
	 */
	public static final String ESTILO_BOTON_RESPONSIVE = "boton-responsive";
	
	/**
	 * Estilo para botones que se adapten al tamaño de la pantalla: si la pantalla es demasiado pequeña, no se muestra el texto del boton, solo es icono
	 */
	public static final String ESTILO_BOTON_TXT_IZQ = "boton-txt-izq";
	
	/**
	 * Estilo para fijar como color de fondo el color de error claro (rojo) y como color de texto el color de error mas oscuro
	 */
	public static final String ESTILO_ERROR_BACKGROUND = "error-background";
	/**
	 * Estilo para fijar como color de fondo el color de error mas oscuro (rojo) y como color de texto el color de contraste (normalmente blanco)
	 */
	public static final String ESTILO_ERROR_BACKGROUND_CONTRAST = "error-background-contrast";
	/**
	 * Estilo para fijar como color de fondo el color de exito claro (verde) y como color de texto el color de exito mas oscuro
	 */
	public static final String ESTILO_SUCCESS_BACKGROUND = "success-background";
	/**
	 * Estilo para fijar como color de fondo el color de exito mas oscuro (verde) y como color de texto el color de contraste (normalmente blanco)
	 */
	public static final String ESTILO_SUCCESS_BACKGROUND_CONTRAST = "success-background-contrast";
	/**
	 * Estilo para fijar como color de fondo el color de principal claro (azul por defecto) y como color de texto el color principal mas oscuro
	 */
	public static final String ESTILO_PRIMARY_BACKGROUND = "primary-background";
	/**
	 * Estilo para fijar como color de fondo el color de principal mas oscuro (rojo) y como color de texto el color de contraste (normalmente blanco)
	 */
	public static final String ESTILO_PRIMARY_BACKGROUND_CONTRAST = "primary-background-contrast";
	
	/**
	 * Azul
	 */
	public static final String ESTILO_BLUE_BACKGROUND = "blue-background";
	public static final String ESTILO_BLUE_BACKGROUND_CONTRAST = "blue-background-contrast";
	/**
	 * Dorado
	 */
	public static final String ESTILO_GOLD_BACKGROUND = "gold-background";
	public static final String ESTILO_GOLD_BACKGROUND_CONTRAST = "gold-background-contrast";
	/**
	 * Gris
	 */
	public static final String ESTILO_GREY_BACKGROUND = "grey-background";
	public static final String ESTILO_GREY_BACKGROUND_CONTRAST = "grey-background-contrast";
	
	public static final String ESTILO_ICONO_REDONDO = "icono-redondo";
	
	/**
	 * Triaje rojo
	 */
	public static final String ESTILO_TRIAJE_ROJO = "triaje-rojo";
	/**
	 * Triaje naranja
	 */
	public static final String ESTILO_TRIAJE_NARANJA = "triaje-naranja";
	/**
	 * Triaje amarillo
	 */
	public static final String ESTILO_TRIAJE_AMARILLO = "triaje-amarillo";
	/**
	 * Triaje azul
	 */
	public static final String ESTILO_TRIAJE_AZUL = "triaje-azul";
	
	/**
	 * Triaje verde
	 */
	public static final String ESTILO_TRIAJE_VERDE = "triaje-verde";
	
	/**
	 * Triaje parpadeo
	 */
	public static final String ESTILO_TRIAJE_BLINK = "triaje-blink";
	
	//botones e iconos
	public static final String BOTON_ICONO_LST = "24px";
	public static final String ICONO_BOTON_LST = "22px";
	
	//Rutas navegacion UI
	public static final String CONSULTAS_RUTA = "consultas";
	public static final String HOSPITALIZACION_RUTA = "hospitalizados";
	public static final String INICIO_RUTA = "inicio";
	public static final String FAV_RUTA = "favoritos";
	public static final String URGENCIAS_RUTA = "urgencias";
	public static final String QUIROFANO_RUTA = "quirofano";
	public static final String CMA_RUTA = "cma";
	public static final String HDIA_RUTA = "hdia";
	public static final String HDOM_RUTA = "hdom";
	public static final String PRIMARIA_RUTA = "primaria";
	public static final String PRUEBAS_RUTA = "pruebas";
	public static final String PRUEBAS_RX_RUTA = "pruebasRX";
	public static final String PROCESOS_RUTA = "procesos";
	public static final String ZONAS_RUTA = "zonas";
	public static final String VIRAS_RUTA = "viras";
	public static final String REG_RUTA = "infExt";
	
	/* colores de iconos */
	public static final String COLOR_ICONO_CDA_XML= "#da65f7";
	public static final String COLOR_ICONO_FIRMA = "black"; 
	public static final String COLOR_ICONO_LAB = "#44cece"; 
	public static final String COLOR_ICONO_RX = "#ca8d1c"; 
	public static final String COLOR_ICONO_EDITAR= "#0db15d";
	public static final String COLOR_ICONO_OPCIONES = "grey"; 
	public static final String COLOR_ICONO_BORRAR = "silver"; 
	public static final String COLOR_ICONO_RECUPERAR = "#b1950d"; 
	public static final String COLOR_ICONO_RESTRINGIR = "#f17d7d"; 
	public static final String COLOR_ICONO_ANONIMO = "#b71c47eb"; 

	
	/* colores de peticiones */
	public static final String COLOR_PETICION_RETENIDAS = "#fb7171"; //RED similar 
	public static final String COLOR_PETICION_INI_EXTRA = "PINK";
	public static final String COLOR_PETICION_EXTRAIDA = "#fbc86b"; //ORANGE YELLOW similar
	public static final String COLOR_PETICION_TRAMITADA = "rgb(238, 174, 130)"; //ORANGE similar
	public static final String COLOR_PETICION_ENVIADAS = "#ffff93"; //YELLOW similar
	public static final String COLOR_PETICION_NO_VISTAS = "#3f47cc";//BLUE;
	public static final String COLOR_PETICION_VISTAS = "#79df79"; //GREEN similar
	public static final String COLOR_PETICION_FINALIZADA= "#79df79";//GREEN similar
	public static final String COLOR_PETICION_VACIAS = "#F8F8F8"; //WHITE similar
	public static final String COLOR_PETICION_MUESTRA_RECIBIDA = "#ff9bff";
	public static final String COLOR_PETICION_PENDIENTE_VER = "255, 225, 220"; //PINK similar
	public static final String COLOR_PETICION_ERRONEA = "WHITE";
	public static final String COLOR_PETICION_CITADA = "#00ecec"; //CYAN similar
	public static final String COLOR_PETICION_VALIDADA= "rgb(136, 216, 251)"; //BLUE similar
	
	/* colores de episodios pendientes */
	public static final String COLOR_EPISODIO_CITAS = "#cae4ff";
	public static final String COLOR_EPISODIO_ESPERA = "#ffe7ce";
	public static final String COLOR_EPISODIO_PROGRAMACION = "#ffc6c6";
	
	// Colroes estados para las citas pacientes, pestaña consultas externas
	public static final String COLOR_ESTADO_PRESENCIA_CITAS_NO_PRESENTE = "#c0c0c0";
	public static final String COLOR_ESTADO_PRESENCIA_CITAS_PRESENTE = "ORANGE";
	public static final String COLOR_ESTADO_PRESENCIA_CITAS_PRESENTE_PUERTA = "#C8C653";
	public static final String COLOR_ESTADO_PRESENCIA_CITAS_LLAMADO = "RED";
	public static final String COLOR_ESTADO_PRESENCIA_CITAS_ATENTIDO = "#5fbf5f";
	public static final String COLOR_ESTADO_PRESENCIA_CITAS_NO_LLAMAR_MAS = "#30cb4d";
	public static final String COLOR_ESTADO_PRESENCIA_CITAS_AUSENTE = "#95ABE8";
	public static final String COLOR_ESTADO_PRESENCIA_CITAS_NO_ATENDIDO ="#bec82a";
	public static final String COLOR_ESTADO_PRESENCIA_CITAS_CONSULTA = "CYAN"; // tal vez mejor rgb(190,200,255)

	
	//public static final String LISTA_DNIs_DESARROLLO = "70884415W|06580067C|07996399N|70891843|32774958G";

}
