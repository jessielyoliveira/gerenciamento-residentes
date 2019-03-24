package com.pds.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pds.model.Residencia;
import com.pds.service.ResidenciaService;

@Controller
public class ResidenciaController {
	
	@Autowired
	private ResidenciaService residenciaService;
	
	
	@RequestMapping("/residencias")
	public String indexResidencia(Model model) {
		List<Residencia> lista = residenciaService.findAll();
		model.addAttribute("listaResidencias", lista);
		return "residencia/homeResidencia"; 
	}
	
	// Abre o formulario de cadastro de residencias
	@RequestMapping("/residencias/nova")
	public String criar(Model model) {
		model.addAttribute("residencia", new Residencia());
		return "residencia/formResidencia";
	}
	
	// Envia as informacoes do formulario para a camada de servico
	@RequestMapping(value = "/residencias/salvar", method = RequestMethod.POST)
	public String salvar(@Valid Residencia residencia) {
		System.out.println(residencia.getId());
		residenciaService.save(residencia);
		return "redirect:/residencias";
	}
	
	@GetMapping("/residencias/remover/{id}")
	public String remover(@PathVariable("id") Integer id) {
		if (id != null) {
			Residencia residencia = residenciaService.findOne(id).get();
			residenciaService.delete(residencia);
		}
		return "redirect:/residencias";
	}
	
	@RequestMapping("/residencias/editar/{id}")
	public String atualizar(Model model, @PathVariable Integer id) {
		System.out.println(id);
		if (id != null) {
			Residencia residencia = residenciaService.findOne(id).get();
			model.addAttribute("residencia", residencia);
			System.out.println(residencia.getId());
		}
		return "residencia/formResidencia";
	}

}
