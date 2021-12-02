package es.horus.altamira.basic.demo.conf.error;

import javax.servlet.http.HttpServletResponse;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;
import com.vaadin.flow.router.NotFoundException;

public class NotFoundErrorView extends VerticalLayout implements HasErrorParameter<NotFoundException> {

    private Span explanation;

    public NotFoundErrorView() {
        H1 header = new H1("La página solicitada no se ha encontrado");
        add(header);

        explanation = new Span();
        add(explanation);
        Icon icon = VaadinIcon.CHEVRON_CIRCLE_RIGHT.create();
        icon.setColor("green");
        Button button = new Button("Volver a la pagina de inicio", icon, e->UI.getCurrent().navigate(""));
		add(button);
    }

    @Override
    public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<NotFoundException> parameter) {
        explanation.setText("No se ha podido ir a la página '" + event.getLocation().getPath() + "'.");
        return HttpServletResponse.SC_NOT_FOUND;
    }

}
