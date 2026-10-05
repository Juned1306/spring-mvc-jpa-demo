package com.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.entity.RegisterBo;
import com.mvc.service.RegisterService;

@Controller

public class RegisterationController {

	
	@Autowired
	private RegisterService service;
	
	@RequestMapping("/register")
	public String register() {
		// String value=null;
		 //System.out.println(value.equals("logical name"));
		 
		 return "registration";
	}
	
	@RequestMapping(path="/printDetail",method = RequestMethod.POST)
	public String detail(
			@ModelAttribute RegisterBo bo
			              ) {
             // String username = detail.getUsername();
              //int data=Integer.parseInt("abc");
		// model.addAttribute("detail", detail);
		  service.insertData(bo);
		
		 return "status";
	}
	
	@RequestMapping("/fetch")
	public String printData(Model model) {
		 
		    List<RegisterBo> data = 
		    		service.getData();
		    
		    model.addAttribute("data", data);
		    
		    return "print";
		
	}
	

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
