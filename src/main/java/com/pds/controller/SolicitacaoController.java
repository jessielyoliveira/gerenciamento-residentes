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

import com.pds.model.Servico;
import com.pds.model.Solicitacao;
import com.pds.service.SolicitacaoService;

@Controller
@RequestMapping("/solicitacoes")
public class SolicitacaoController {
	
	@Autowired
	private SolicitacaoService solicitacaoService;
	
	
	@GetMapping
	public String indexSolicitacao(Model model) {
		List<Solicitacao> lista = solicitacaoService.findAll();
		model.addAttribute("listaSolicitacao", lista);
		return "solicitacao/homeSolicitacao"; 
	}
	
	// Abre o formulario de cadastro de solicitacao
	@GetMapping("/nova")
	public String solicitacaoForm(Model model) {
		model.addAttribute("solicitacao", new Solicitacao());
		return "solicitacao/formSolicitacao";
	}
	
	// Envia as informacoes do formulario para a camada de servico
	@PostMapping("/nova")
	public String solicitacaoSubmit(@ModelAttribute Solicitacao solicitacao) {
		solicitacaoService.save(solicitacao);
		return "redirect:/solicitacoes";
	}
	
	@GetMapping("/remover/{id}")
	public String remover(@PathVariable("id") Integer id) {
		if (id != null) {
			Solicitacao solicitacao = solicitacaoService.findOne(id).get();
			solicitacaoService.delete(solicitacao);
		}
		return "redirect:/solicitacoes";
	}
	
}
