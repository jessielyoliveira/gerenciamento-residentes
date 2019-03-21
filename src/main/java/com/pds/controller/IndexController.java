package com.pds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	// Recebe um endereco e retorna a pagina de inicio
	@RequestMapping("/")
	public String index() {
		return "home";
	}
	
}
