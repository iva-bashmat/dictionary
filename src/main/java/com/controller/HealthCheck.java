package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
	
	@RequestMapping(value = "/isalive", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
    public void index() {
    }
}
