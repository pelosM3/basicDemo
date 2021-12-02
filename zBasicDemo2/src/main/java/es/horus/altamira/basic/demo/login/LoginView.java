package es.horus.altamira.basic.demo.login;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginI18n.Form;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouteConfiguration;

import es.horus.altamira.basic.demo.common.UtilsUI;
import es.horus.altamira.basic.demo.conf.error.MainErrorHandler;
import es.horus.altamira.basic.demo.main.MainLayout;

@Route("login")
@RouteAlias("")
@PageTitle("Inicio")
@CssImport("./styles/login.css")
@CssImport(value="./styles/loginForm.css", themeFor = "vaadin-login-form-wrapper")
public class LoginView extends FlexLayout implements HasUrlParameter<String> {

	private LoginForm loginForm;
	
	@Override
	protected void onAttach(AttachEvent attachEvent) {
		super.onAttach(attachEvent);
		setSizeFull();
        setClassName("login-screen");
        
        FlexLayout centeringLayout = new FlexLayout();
        centeringLayout.setSizeFull();
        centeringLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        centeringLayout.setAlignItems(Alignment.CENTER);
        centeringLayout.add(buildLoginForm());

        add(centeringLayout);
	}


	//Todo redirige al login y no da vista no existe
	@Override
	public void setParameter(BeforeEvent event,@OptionalParameter String parameter) {
	}
	
	private Component buildLoginForm() {
		FlexLayout mainLayout = new FlexLayout();
        mainLayout.setClassName("pantalla-login");
		
		VerticalLayout izqLayout = new VerticalLayout();
		izqLayout.setClassName("contenedor-formulario-login");
		izqLayout.setAlignItems(Alignment.CENTER);
		mainLayout.add(izqLayout);
		
		HorizontalLayout container = new HorizontalLayout();
		container.setSizeFull();
		container.setDefaultVerticalComponentAlignment(Alignment.CENTER);
		izqLayout.add(container);
		
		loginForm = new LoginForm();
		loginForm.getElement().getStyle().set("width", "100%");
		loginForm.setForgotPasswordButtonVisible(false);
		loginForm.addLoginListener(e->login(e.getUsername(), e.getPassword()));
		LoginI18n loginI18n = new LoginI18n();
		loginI18n.setForm(new Form());
		loginI18n.getForm().setTitle("Acceso");
		loginI18n.getForm().setUsername("Usuario");
		loginI18n.getForm().setPassword("Contraseña");
		loginI18n.getForm().setSubmit("Entrar");
		loginForm.setI18n(loginI18n);
		container.add(loginForm);
		UI.getCurrent().getPage().executeJs("document.getElementById(\"vaadinLoginUsername\").children[0].focus();");
		
		Image scsLogo = new Image("images/logoSCS.png", "SCS");
		scsLogo.setWidth("200px");
		izqLayout.add(scsLogo);
		
		HorizontalLayout botonera = new HorizontalLayout();
		izqLayout.add(botonera);
		
		botonera.add(new Button(VaadinIcon.INFO_CIRCLE.create()), new Button(VaadinIcon.QUESTION_CIRCLE.create()));
		
		String version = "demo1";
		Html htmlVersion = new Html("<span> " + version + "</span>");
		htmlVersion.getElement().getStyle().set("font-size", "small");
		htmlVersion.getElement().getStyle().set("text-align", "center");
		izqLayout.add(htmlVersion);
		
		// concatenar nombre de máquina
		try {
			InetAddress addr = InetAddress.getLocalHost();

			Html htmlNodo = new Html("<span> " + addr.getHostName() + "</span>");
			htmlNodo.getElement().getStyle().set("font-size", "small");
			htmlNodo.getElement().getStyle().set("margin-top", "0");
			htmlNodo.getElement().getStyle().set("text-align", "center");
			izqLayout.add(htmlNodo);
		} catch (UnknownHostException err) {
			err.printStackTrace();
		}
		
		VerticalLayout derLayout = new VerticalLayout();
		derLayout.setClassName("contenedor-logo-login");
		mainLayout.add(derLayout);
		
		Image image = new Image("images/logoaltamiratransparenteBlanco.png", "Altamira");
		image.addClassName("logo-login");
		image.setWidthFull();
		
		HorizontalLayout imageLayout = new HorizontalLayout(image);
		imageLayout.setWidthFull();
		imageLayout.setVerticalComponentAlignment(Alignment.CENTER, image);
		derLayout.addAndExpand(imageLayout);
		derLayout.setAlignSelf(Alignment.CENTER);
		
		return mainLayout;
	}
 

	private void login(String user,String pass) {
		try {
			if(user==null || user.isEmpty()) {
				UtilsUI.notification("Se debe especificar un usuario");
			}else if(pass==null || pass.isEmpty()) {
				UtilsUI.notification("Se debe especificar una contraseña");
			}else if(!user.equalsIgnoreCase("111")) {
				AccessControl.getInstance().signIn(user, pass);
				RouteConfiguration.forSessionScope().setRoute("main", MainLayout.class);
				UI.getCurrent().navigate("main");
			}else {
				UtilsUI.notification("Usuario/contraseña incorrecto / no disponible");
			}
		} catch (Exception e) {
			MainErrorHandler.handleError(e);
		}
		loginForm.setEnabled(true);
	}
	
}
