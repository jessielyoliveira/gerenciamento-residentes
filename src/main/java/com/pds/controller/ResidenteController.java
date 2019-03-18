package com.pds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pds.model.Residente;
import com.pds.service.ResidenteService;

@Controller
@RequestMapping("/residentes")
public class ResidenteController {
	@Autowired
	private ResidenteService residenteService;

	// Abre o formulario de cadastro de residentes
	@GetMapping("/novo")
	public String cadastrarResidente() {
		return "residente/cadastroResidente";
	}
	
	// Envia as informacoes do formulario para a camada de servico e direciona para a index
	@PostMapping("/novo")
	public String cadastrarResidente(Residente residente) {
		residenteService.save(residente);
		return "redirect:/";
	}
}
