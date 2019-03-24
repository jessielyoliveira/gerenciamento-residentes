package com.pds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pds.model.Residencia;
import com.pds.model.Residente;
import com.pds.service.ResidenteService;

@Controller
@RequestMapping("/residentes")
public class ResidenteController {
	@Autowired
	private ResidenteService residenteService;
	
	@GetMapping
	public String indexResidencia(Model model) {
		List<Residente> lista = residenteService.findAll();
		model.addAttribute("listaResidentes", lista);
		return "residente/homeResidente"; 
	}
	
	// Abre o formulario de cadastro de residentes
	@GetMapping("/novo")
	public String residenteForm(Model model) {
		model.addAttribute("residente", new Residente());
		return "residente/formResidente";
	}
	
	// Envia as informacoes do formulario para a camada de servico
	@PostMapping("/novo")
	public String residenteSubmit(@ModelAttribute Residente residente) {
		residenteService.save(residente);
		return "redirect:/residentes";
	}
}
