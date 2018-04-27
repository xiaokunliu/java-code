package com.crazysales.httprest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap;
import org.springframework.web.filter.CharacterEncodingFilter;
import com.crazysales.httprest.context.RestContextLoaderListener;

/**
 * @author laudin
 */
public class Bootstrap {
	
    public static void main(String[] args) throws Exception {      
	  
    	  ServletContextHandler handler = new ServletContextHandler();
          handler.setContextPath("/csapi");
          handler.addEventListener(new ResteasyBootstrap());
          handler.addEventListener(new RestContextLoaderListener());
          handler.setInitParameter("contextConfigLocation", "classpath:application-root.xml");

          FilterHolder encodingHolder = new FilterHolder();
          encodingHolder.setFilter(new CharacterEncodingFilter());
          encodingHolder.setInitParameter("encoding", "UTF-8");
          encodingHolder.setInitParameter("forceEncoding", "true");
 
          handler.addFilter(encodingHolder, "/*", null);
          handler.addServlet(HttpServletDispatcher.class, "/*");
          handler.setInitParameter("resteasy.servlet.mapping.prefix","/");
          handler.setInitParameter("resteasy.media.type.mappings","html : text/html, json : application/json, xml : application/xml");
        
          Server httpServer = new Server();
          SelectChannelConnector connector = new SelectChannelConnector();
          connector.setPort(8001);
          httpServer.addConnector(connector);

          httpServer.setHandler(handler);
          httpServer.start();
          httpServer.join();
    }
}
