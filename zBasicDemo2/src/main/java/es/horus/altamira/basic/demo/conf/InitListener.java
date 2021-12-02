package es.horus.altamira.basic.demo.conf;

import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;

import es.horus.altamira.basic.demo.conf.error.MainErrorHandler;
import es.horus.altamira.basic.demo.login.AccessControl;
import es.horus.altamira.basic.demo.login.LoginView;

/**
 * Listener que se ejecuta para cada UI. Se utiliza para saber si el usuario esta autenticado, y si no redirigirlo
 * a la pantalla de login. Esta clase hay que registrarla en el fichero:
 *  META-INF/services/com.vaadin.flow.server.VaadinServiceInitListener
 *
 */
public class InitListener implements VaadinServiceInitListener {
    @Override
    public void serviceInit(ServiceInitEvent initEvent) {
        final AccessControl accessControl = AccessControl.getInstance();

        initEvent.getSource().addSessionInitListener(e->e.getSession().setErrorHandler(new MainErrorHandler()));
        
        initEvent.getSource().addUIInitListener(uiInitEvent -> {
        	uiInitEvent.getUI().add(new InitPageConfigurator());
            uiInitEvent.getUI().addBeforeEnterListener(enterEvent -> {
                if (!accessControl.isUserSignedIn() && !LoginView.class.equals(enterEvent.getNavigationTarget())) {
                	enterEvent.rerouteTo(LoginView.class);
                }
            });
        });
    }
}
