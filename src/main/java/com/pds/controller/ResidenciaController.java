package com.pds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String indexResidencia(Model model) {
		List<Residencia> lista = residenciaService.findAll();
		model.addAttribute("listaResidencias", lista);
		return "residencia/homeResidencia"; 
	}
	
	// Abre o formulario de cadastro de residencias
	@GetMapping("/nova")
	public String residenciaForm(Model model) {
		model.addAttribute("residencia", new Residencia());
		return "residencia/cadastroResidencia";
	}
	
	// Envia as informacoes do formulario para a camada de servico
	@PostMapping("/nova")
	public String residenciaSubmit(@ModelAttribute Residencia residencia) {
		residenciaService.save(residencia);
		return "redirect:/residencias";
	}
	
	@GetMapping("/remover/{id}")
	public String remover(@PathVariable("id") Integer id) {
		if (id != null) {
			Residencia residencia = residenciaService.findOne(id).get();
			residenciaService.delete(residencia);
		}
		return "redirect:/residencias";
	}
	
	

}
