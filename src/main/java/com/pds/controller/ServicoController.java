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
import com.pds.model.Servico;
import com.pds.service.ServicoService;

@Controller
@RequestMapping("/servicos")
public class ServicoController {
	
	@Autowired
	private ServicoService servicoService;
	
	
//	@GetMapping
//	public String indexServico(Model model) {
//		List<Servico> lista = servicoService.findAll();
//		model.addAttribute("listaServico", lista);
//		return "solicitacao/formServico"; 
//	}
	
	// Abre o formulario de cadastro de servico
	@GetMapping("/novo")
	public String servicoForm(Model model) {
		model.addAttribute("servico", new Servico());
		return "solicitacao/formServico";
	}
	
	// Envia as informacoes do formulario para a camada de servico
	@PostMapping("/novo")
	public String servicoSubmit(@ModelAttribute Servico servico) {
		servicoService.save(servico);
		return "redirect:/solicitacoes";
	}
	
	@GetMapping("/remover/{id}")
	public String remover(@PathVariable("id") Integer id) {
		if (id != null) {
			Servico servico = servicoService.findOne(id).get();
			servicoService.delete(servico);
		}
		return "redirect:/solicitacoes";
	}
	
	
}
