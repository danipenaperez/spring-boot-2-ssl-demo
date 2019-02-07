package com.dppware.demossl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	
	@Value(value="${some.key:defaultvalue}")
	private String prop;
	
    @RequestMapping("/")
    public String index() {
    	LOGGER.trace("doStuff needed more information - {}", "");
        return "Greetings from Spring Boot! "+ prop;
    }

}