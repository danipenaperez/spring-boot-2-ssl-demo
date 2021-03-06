package com.dppware.demossl.config;

import org.apache.catalina.connector.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class HttpsServerConfig {
	/**
	 * The logger
	 */
	Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyListener.class);
	
	
	/**
	 * 
	 * @param httpPort
	 * @return
	 */
	@Bean
	@ConditionalOnProperty(prefix="server", name="http.enabled")
	public ServletWebServerFactory servletContainer(@Value("${server.http.port:8080}") int httpPort) {
		Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
		connector.setPort(httpPort);

		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.addAdditionalTomcatConnectors(connector);
		return tomcat;
	}
	
	
	
	
}
