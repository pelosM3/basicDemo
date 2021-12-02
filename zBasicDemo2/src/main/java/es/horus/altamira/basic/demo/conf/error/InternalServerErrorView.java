package es.horus.altamira.basic.demo.conf.error;

import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;
import com.vaadin.flow.router.InternalServerError;

public class InternalServerErrorView extends InternalServerError implements HasErrorParameter<Exception> {

	@Override
	public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<Exception> parameter) {
		MainErrorHandler.error(parameter.getException());
		return super.setErrorParameter(event, parameter);
	}
}
