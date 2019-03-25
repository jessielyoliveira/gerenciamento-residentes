package com.pds.controller;

import java.util.List;
import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pds.exception.BusinessException;
import com.pds.exception.ModelException;
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
	
	@GetMapping("/nova")
	public String criar(Model model) {
		model.addAttribute("residencia", new Residencia());
		return "residencia/formResidencia";
	}
	
	@PostMapping
	public String salvar(@Valid Residencia residencia, RedirectAttributes alerta) {
		try {
			residenciaService.validar(residencia);
			residenciaService.existe(residencia);
			residenciaService.save(residencia);
			alerta.addFlashAttribute("sucesso", "Residência inserida");
		} catch (BusinessException e) {
			e.printStackTrace();
			alerta.addFlashAttribute("erro", "Erro na inserção da residência [" + e.getMessage() + "]");
		} catch (ModelException e) {
			e.printStackTrace();
			alerta.addFlashAttribute("aviso", "Residência já existe [" + e.getMessage() + "]");
		}
		return "redirect:/residencias";
	}
	
	@GetMapping("/remover/{id}")
	public String remover(@PathVariable Integer id) {
		if (id != null) {
			Residencia residencia = residenciaService.findOne(id).get();
			residenciaService.delete(residencia);
		}
		return "redirect:/residencias";
	}
	
	@GetMapping("/editar/{id}")
	public String atualizar(@PathVariable Integer id, Model model) {
		try {
			if (id != null) {
				Residencia residencia = residenciaService.findOne(id).get();
				model.addAttribute("residencia", residencia);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return "residencia/formResidencia";
	}
	
	@PutMapping
	public String atualizar(@Valid Residencia residencia, RedirectAttributes alerta) {
		try {
			residenciaService.validar(residencia);
			residenciaService.save(residencia);
			alerta.addFlashAttribute("sucesso", "Residência atualizada");
		} catch (BusinessException e) {
			e.printStackTrace();
			alerta.addFlashAttribute("erro", "Erro na atualização da residência [" + e.getMessage() + "]");
		} 
		return "redirect:/residencias";
	}

}
