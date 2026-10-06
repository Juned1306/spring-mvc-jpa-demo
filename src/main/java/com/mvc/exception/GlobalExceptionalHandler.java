package com.mvc.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionalHandler {
	
	
	/*
	@ExceptionHandler(value = NullPointerException.class)
	public String getNullExceptionHandler(Model model) {
		model.addAttribute("msg", "Because of No value passed in the string");
		     return "errorPage";
	}
	
	@ExceptionHandler(value = NumberFormatException.class)
	public String getNumberFormatExceptionHandler(Model model) {
		model.addAttribute("msg", "Because of wrong input convertion to int type");
		     return "errorPage";
	}
	*/
	
	@ExceptionHandler(value = Exception.class)
	public String getExceptionHandler(Model model) {
		model.addAttribute("msg", "Check your controller method based on URL");
		     return "errorPage";
	}
}
