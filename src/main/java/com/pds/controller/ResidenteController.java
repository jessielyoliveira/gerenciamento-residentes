package com.pds.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pds.exception.BusinessException;
import com.pds.exception.ModelException;
import com.pds.model.Residente;
import com.pds.service.ResidenteService;

@Controller
@RequestMapping("/residentes")
public class ResidenteController {
	@Autowired
	private ResidenteService residenteService;
	

	@GetMapping
	public String portalResidente() {
		return "residente/portalResidente";
	}
	
	@GetMapping("/gerenciar")
	public String indexResidente(Model model) {
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
	@PostMapping
	public String salvar(@ModelAttribute Residente residente, RedirectAttributes alerta) {
		try {
			residenteService.validate(residente);
			residenteService.alreadyExists(residente);
			residenteService.save(residente);
			alerta.addFlashAttribute("sucesso", "O Residente foi cadastrado com sucesso");
		} catch (BusinessException e) {
			e.printStackTrace();
			alerta.addFlashAttribute("erro", "Erro na inserção do residente [" + e.getMessage() + "]");
			return "redirect:/residentes/novo";
		} catch (ModelException e) {
			e.printStackTrace();
			alerta.addFlashAttribute("aviso", "Residente já existe [" + e.getMessage() + "]");
			return "redirect:/residentes/novo";
		}
		
		return "redirect:/residentes/gerenciar";		
	}
	
	@GetMapping("/editar/{id}")
	public String atualizar(@PathVariable Integer id, Model model) {
		try {
			if (id != null) {
				Residente residente = residenteService.findOne(id).get();
				model.addAttribute("residente", residente);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return "residente/formResidente";
	}
	
	@PutMapping
	public String atualizar(@Valid Residente residente, RedirectAttributes alerta) {
		try {
			residenteService.validate(residente);
			residenteService.save(residente);
			alerta.addFlashAttribute("sucesso", "Residente atualizado com sucesso");
		} catch (BusinessException e) {
			e.printStackTrace();
			alerta.addFlashAttribute("erro", "Erro na atualiza��o do residente [" + e.getMessage() + "]");
		} 
		return "redirect:/residentes/gerenciar";
	}
	
	@GetMapping("/remover/{id}")
	public String remover(@PathVariable("id") Integer id) {
		if (id != null) {
			Residente residente = residenteService.findOne(id).get();
			residenteService.delete(residente);
		}
		return "redirect:/residentes/gerenciar";
	}
	
	//bug: se buscar mais de uma vez ele vai para o endereï¿½o residentes/residentes/.../busca [RESOLVIDO]
	@PostMapping("/busca")
	public String buscar(Model model, @RequestParam("chave") String chave) {
		List<Residente> lista = residenteService.search(chave);
		model.addAttribute("listaResidentes", lista);
		return "residente/homeResidente"; 
	}
	
	@GetMapping("/detalhes/{id}")
	public String detalhar(@PathVariable Integer id, Model model) {
		try {
			if (id != null) {
				Residente residente = residenteService.findOne(id).get();
				model.addAttribute("residente", residente);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return "residente/detalhesResidente";
	}
}
