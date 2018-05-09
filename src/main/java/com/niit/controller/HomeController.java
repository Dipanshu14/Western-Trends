package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.niit.service.ProductService;

@Controller
public class HomeController {
	@Autowired
	ProductService productService;
	
	@RequestMapping(value= {"/","/index"})
	public String homePage()
	{
		return "index";
	}
	@RequestMapping("/aboutus")	
	public String aboutUs()
	{
		return "aboutUs";
	}
	
}
