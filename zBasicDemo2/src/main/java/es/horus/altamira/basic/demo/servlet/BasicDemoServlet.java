package es.horus.altamira.basic.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.vaadin.flow.server.VaadinServlet;

import es.horus.altamira.basic.demo.common.DataSource;

@WebServlet(urlPatterns = "/*", name = "mainServlet", asyncSupported = true, loadOnStartup = 1, initParams = {
		@WebInitParam(name = "pushmode", value = "automatic")
})
public class BasicDemoServlet extends VaadinServlet{
	 

	@Override
    protected void servletInitialized() throws ServletException {
		DataSource.init();
	}
	
}
