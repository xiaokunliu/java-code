package com.crazysales.httprest.context;

import javax.servlet.ServletContext;

import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.spi.Registry;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.springframework.web.context.ConfigurableWebApplicationContext;

public class RestSpringContextLoaderSupport {
	 public void customizeContext(ServletContext servletContext, ConfigurableWebApplicationContext configurableWebApplicationContext)
	   {
	      ResteasyProviderFactory providerFactory = (ResteasyProviderFactory) servletContext.getAttribute(ResteasyProviderFactory.class.getName());
	      if (providerFactory == null)
	         throw new RuntimeException("RESTeasy Provider Factory is null, do you have the ResteasyBootstrap listener configured?");

	      Registry registry = (Registry) servletContext.getAttribute(Registry.class.getName());
	      if (registry == null)
	         throw new RuntimeException("RESTeasy Registry is null, do ou have the ResteasyBootstrap listener configured?");

	      Dispatcher dispatcher = (Dispatcher) servletContext.getAttribute(Dispatcher.class.getName());
	      if (dispatcher == null)
	         throw new RuntimeException("RESTeasy Dispatcher is null, do ou have the ResteasyBootstrap listener configured?");

	      RestSpringBeanProcessor processor = new RestSpringBeanProcessor(dispatcher, registry, providerFactory);
	      configurableWebApplicationContext.addBeanFactoryPostProcessor(processor);
	      configurableWebApplicationContext.addApplicationListener(processor);
	   }
}
