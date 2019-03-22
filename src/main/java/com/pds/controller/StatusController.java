package com.pds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pds.model.Status;
import com.pds.service.StatusService;



@Controller
@RequestMapping("/status")
public class StatusController {
	@Autowired
	private StatusService statusService;
	
	
//	@GetMapping
//	public String indexServico(Model model) {
//		List<Servico> lista = servicoService.findAll();
//		model.addAttribute("listaServico", lista);
//		return "solicitacao/formServico"; 
//	}
	
	// Abre o formulario de cadastro de servico
	@GetMapping("/novo")
	public String servicoForm(Model model) {
		model.addAttribute("status", new Status());
		return "solicitacao/formServico";
	}
	
	// Envia as informacoes do formulario para a camada de servico
	@PostMapping("/novo")
	public String servicoSubmit(@ModelAttribute Status status) {
		statusService.save(status);
		return "redirect:/solicitacoes";
	}
	
	@GetMapping("/remover/{id}")
	public String remover(@PathVariable("id") Integer id) {
		if (id != null) {
			Status status = statusService.findOne(id).get();
			statusService.delete(status);
		}
		return "redirect:/solicitacoes";
	}
}
