package es.horus.altamira.basic.demo.login;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.server.WrappedHttpSession;

import es.horus.altamira.basic.demo.common.UtilsUI;

public class AccessControl {
	public static final String CURRENT_USER_SESSION_ATTRIBUTE_KEY = AccessControl.class.getCanonicalName();
	public static final String FECHALOGIN = "lista.vistas.permitidas";
	
	private static final AccessControl accessControl = new AccessControl();
	
	
    public boolean signIn(String user, String pwd) {
        if (user == null) {
        	return false;
        }
        
        getSession().setAttribute(CURRENT_USER_SESSION_ATTRIBUTE_KEY, user);
        getSession().setAttribute(FECHALOGIN, UtilsUI.hoyFormateado());	
        return true;
    }

	private WrappedHttpSession getSession() {
		return (WrappedHttpSession) VaadinSession.getCurrent().getSession();
	}

    public boolean isUserSignedIn() {
    	WrappedHttpSession session = getSession();
		return session != null && session.getAttribute(CURRENT_USER_SESSION_ATTRIBUTE_KEY) != null;
    }

    public String getFechaLogin(){
    	return (String) getSession().getAttribute(FECHALOGIN);
    }

    public String getUserLogin(){
    	return (String) getSession().getAttribute(CURRENT_USER_SESSION_ATTRIBUTE_KEY);
    }
    
    public void signOut() {
        VaadinSession.getCurrent().getSession().invalidate();
        UI.getCurrent().navigate("");
        UI.getCurrent().getPage().reload();
    }

	public static AccessControl getInstance() {
		return accessControl;
	}
}
