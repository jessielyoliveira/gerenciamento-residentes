package com.pds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pds.model.Residencia;
import com.pds.service.ResidenciaService;

@Controller
@RequestMapping("/residencias")
public class ResidenciaController {
	
	@Autowired
	private ResidenciaService residenciaService;
	
	@GetMapping
	public String indexResidencia() {
		return "residencia/indexResidencia";
	}
	
	// Abre o formulario de cadastro de residencias
	@GetMapping("/nova")
	public String cadastrarResidencia() {
		return "residencia/cadastroResidencia";
	}
	
	// Envia as informacoes do formulario para a camada de servico
	@PostMapping("/nova")
	public String cadastrarResidencia(Residencia residencia) {
		residenciaService.save(residencia);
		return "redirect:/";
	}

}
