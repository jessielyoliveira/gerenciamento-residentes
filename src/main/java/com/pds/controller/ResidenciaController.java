package com.pds.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pds.model.Residencia;
import com.pds.service.ResidenciaService;

@Controller
@RequestMapping("/residencias")
public class ResidenciaController {
	
	@Autowired
	private ResidenciaService residenciaService;
	
	/*
	 * @GetMapping public String indexResidencia() { return
	 * "residencia/indexResidencia"; }
	 */
	
	// Abre o formulario de cadastro de residencias
	@GetMapping("/nova")
	public String cadastrarResidencia() {
		return "residencia/cadastroResidencia";
	}
	
	// Envia as informacoes do formulario para a camada de servico
	@PostMapping("/nova")
	public String cadastrarResidencia(Residencia residencia) {
		residenciaService.save(residencia);
		return "redirect:/proae#residencias";
	}
	
	@GetMapping("/remover")
	public String listarResidencias(Model model) {
		List<Residencia> lista = residenciaService.findAll();
		model.addAttribute("listaResidencias", lista);
		return "residencia/listarResidencias";
	}
	
	@RequestMapping("/remover/{id}")
	public String remover(@PathVariable("id") Integer id) {
		if (id != null) {
			Residencia residencia = residenciaService.findOne(id).get();
			residenciaService.delete(residencia);
		}
		return "redirect:/residencias/remover";
	}
	
	

}
