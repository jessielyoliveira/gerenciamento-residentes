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
import com.pds.model.Servico;
import com.pds.model.Status;
import com.pds.service.StatusService;



@Controller
@RequestMapping("/status")
public class StatusController {
	@Autowired
	private StatusService statusService;
	
	
	@GetMapping
	public String indexServico(Model model) {
		List<Status> lista = statusService.findAll();
		model.addAttribute("listaStatus", lista);
		return "status/homeStatus"; 
	}
	
	
	@GetMapping("/novo")
	public String criar(Model model) {
		model.addAttribute("status", new Status());
		return "status/formStatus";
	}
	
	
	@PostMapping
	public String salvar(@Valid Status status, RedirectAttributes alerta) {
		try {
			statusService.validar(status);
			statusService.existe(status);
			statusService.save(status);
			alerta.addFlashAttribute("sucesso", "Status Inserido");
		} catch (BusinessException e) {
			e.printStackTrace();
			alerta.addFlashAttribute("erro", "Erro na insercao do status [" + e.getMessage() + "]");
		} catch (ModelException e) {
			e.printStackTrace();
			alerta.addFlashAttribute("aviso", "Status ja existe [" + e.getMessage() + "]");
		}
		return "redirect:/status";
	}
	
	@GetMapping("/remover/{id}")
	public String remover(@PathVariable("id") Integer id) {
		if (id != null) {
			Status status = statusService.findOne(id).get();
			statusService.delete(status);
		}
		return "redirect:/status";
	}
	
	@GetMapping("/editar/{id}")
	public String atualizar(@PathVariable Integer id, Model model) {
		try {
			if (id != null) {
				Status status = statusService.findOne(id).get();
				model.addAttribute("status", status);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return "status/formStatus";
	}
	
	@PutMapping
	public String atualizar(@Valid Status status, RedirectAttributes alerta) {
		try {
			statusService.validar(status);
			statusService.save(status);
			alerta.addFlashAttribute("sucesso", "Servico atualizado");
		} catch (BusinessException e) {
			e.printStackTrace();
			alerta.addFlashAttribute("erro", "Erro na atualizacao do servico [" + e.getMessage() + "]");
		} 
		return "redirect:/status";
	}
	
	@GetMapping("/detalhes/{id}")
	public String detalhar(@PathVariable Integer id, Model model) {
		try {
			if (id != null) {
				Status status = statusService.findOne(id).get();
				model.addAttribute("status", status);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return "status/detalhesStatus";
	}
	
	@PostMapping("/busca")
	public String buscar(Model model, @RequestParam("chave") String chave) {
		List<Status> lista = statusService.search(chave.toLowerCase());
		model.addAttribute("listaStatus", lista);
		return "status/homeStatus"; 
	}
}
