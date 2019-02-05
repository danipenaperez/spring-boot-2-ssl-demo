package com.dppware.demossl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value(value="${some.key:defaultvalue}")
	private String prop;
	
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot! "+ prop;
    }

}