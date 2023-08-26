package com.floating.contact.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebApplnt implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

	AnnotationConfigWebApplicationContext apc = new AnnotationConfigWebApplicationContext();
	apc.register(SpringMvcConfig.class);
	ServletRegistration.Dynamic dispatcher= servletContext.addServlet("SpringDispatcher",new DispatcherServlet(apc));
	dispatcher.setLoadOnStartup(1);
	dispatcher.addMapping("/");
	}
}

