package com.dppware.demossl.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReadyListener {

	Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyListener.class);
	
	@Value("${server.port}") 
	private int httpPort;
	
	@Value("${server.http.port}")
	private int httpExtraConnectorPort;
	
	@Value("${server.http.enabled:false}") 
	private boolean httpPlainEnabled;
	
	@Value("${site.location}") 
	private String siteLocation;
	
	
	/**
	 * Initialization messages
	 */
	@EventListener({ApplicationReadyEvent.class})
	void applicationReadyEvent() {
		LOGGER.info("Application started ... ");
		LOGGER.info("httpPort {}", httpPort);
		LOGGER.info("httpsPort {}", httpExtraConnectorPort);
		LOGGER.info("httpPlainEnabled {}", httpPlainEnabled);
		LOGGER.info("siteLocation {}", siteLocation);
		
		LOGGER.info("Now This Site is available on https://{}:{}", siteLocation , httpPort);
		if(httpPlainEnabled) {
			LOGGER.info("Now This Site is available too on http://{}:{}", siteLocation , httpExtraConnectorPort);
		}
		
		try {
			LOGGER.info("Remeber add |{} {}| to your /etc/hosts file to avoid ssl_error_bad_cert_domain if not already configured o DNS resolution",siteLocation, InetAddress.getLocalHost().getHostAddress() ) ;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
}
