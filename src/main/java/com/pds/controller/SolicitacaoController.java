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
import com.pds.model.Residencia;
import com.pds.model.Residente;
import com.pds.model.Servico;
import com.pds.model.Solicitacao;
import com.pds.model.Status;
import com.pds.service.ResidenciaService;
import com.pds.service.ServicoService;
import com.pds.service.SolicitacaoService;
import com.pds.service.StatusService;

@Controller
@RequestMapping("/solicitacoes")
public class SolicitacaoController {
	
	@Autowired
	private SolicitacaoService solicitacaoService;
	
	@Autowired
	private ServicoService servicoService;
	
	@Autowired
	private StatusService statusService;
	
	
	@GetMapping
	public String indexSolicitacao(Model model) {
		List<Solicitacao> lista = solicitacaoService.findAll();
		model.addAttribute("listaSolicitacao", lista);
		return "solicitacao/homeSolicitacao"; 
	}
	
	@GetMapping("/acompanharServico")
	public String indexSolicitacaoServico(Model model) {
		List<Solicitacao> lista = solicitacaoService.findAll();
		model.addAttribute("listaSolicitacao", lista);
		return "solicitacao/homeAcompanharServico"; 
	}
	
	@GetMapping("/nova")
	public String criar(Model model) {
		List<Servico> listaServicos = servicoService.findAll();
		model.addAttribute("servicos", listaServicos);
	
		
		List<Status> listaStatus = statusService.findAll();
		model.addAttribute("status", listaStatus);
		
		model.addAttribute("solicitacao", new Solicitacao());
		return "solicitacao/formSolicitacao";
	}
	
	@PostMapping
	public String salvar(@Valid Solicitacao solicitacao, RedirectAttributes alerta) {
		try {
			solicitacaoService.validar(solicitacao);
			solicitacaoService.existe(solicitacao);
			solicitacaoService.save(solicitacao);
			alerta.addFlashAttribute("sucesso", "Solicitação inserida");
		} catch (BusinessException e) {
			e.printStackTrace();
			alerta.addFlashAttribute("erro", "Erro na inserção da solicitação [" + e.getMessage() + "]");
			return "redirect:/solicitacoes/nova";
		} catch (ModelException e) {
			e.printStackTrace();
			alerta.addFlashAttribute("aviso", "Solicitação já existe [" + e.getMessage() + "]");
			return "redirect:/solicitacoes/nova";
		}
		
		return "redirect:/solicitacoes/acompanharServico";
	}
	
	@GetMapping("/remover/{id}")
	public String remover(@PathVariable Integer id) {
		if (id != null) {
			Solicitacao solicitacao = solicitacaoService.findOne(id).get();
			solicitacaoService.delete(solicitacao);
		}
		return "redirect:/solicitacoes";
	}
	
	@GetMapping("/removerSolicitacaoServico/{id}")
	public String removerSolicitacaoServico(@PathVariable Integer id) {
		if (id != null) {
			Solicitacao solicitacao = solicitacaoService.findOne(id).get();
			solicitacaoService.delete(solicitacao);
		}
		return "redirect:/solicitacoes/AcompanharServico";
	}
	
	@GetMapping("/editar/{id}")
	public String atualizar(@PathVariable Integer id, Model model) {
		try {
			if (id != null) {
				Solicitacao solicitacao = solicitacaoService.findOne(id).get();
				model.addAttribute("solicitacao", solicitacao);
				List<Servico> listaServicos = servicoService.findAll();
				model.addAttribute("servicos", listaServicos);
				List<Status> listaStatus = statusService.findAll();
				model.addAttribute("status", listaStatus);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return "solicitacao/formEditarSolicitacao";
	}
	
	@PutMapping
	public String atualizar(@Valid Solicitacao solicitacao, RedirectAttributes alerta) {
		try {
			solicitacaoService.validar(solicitacao);
			solicitacaoService.save(solicitacao);
			alerta.addFlashAttribute("sucesso", "Solicitacao Modificada!");
		} catch (BusinessException e) {
			e.printStackTrace();
			alerta.addFlashAttribute("erro", "Erro na atualizacao da residencia [" + e.getMessage() + "]");
		} 
		return "redirect:/solicitacoes";
	}
	
	@GetMapping("/detalhes/{id}")
	public String detalharProae(@PathVariable Integer id, Model model) {
		try {
			if (id != null) {
				Solicitacao solicitacao = solicitacaoService.findOne(id).get();
				model.addAttribute("solicitacao", solicitacao);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return "solicitacao/detalhesSolicitacao";
	}
	
//	@PostMapping("/busca")
//	public String buscar(Model model, @RequestParam("chave") String chave) {
//		List<Solicitacao> lista = solicitacaoService.search(chave.toLowerCase());
//		model.addAttribute("listaSolicitacao", lista);
//		return "solicitacao/homeSolicitacaoServico"; 
//	}
	
	
}
