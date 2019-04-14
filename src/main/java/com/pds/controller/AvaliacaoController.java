package com.pds.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.pds.model.Avaliacao;
import com.pds.model.Servico;
import com.pds.model.Solicitacao;
import com.pds.model.Status;
import com.pds.service.AvaliacaoService;
import com.pds.service.SolicitacaoService;

@Controller
@RequestMapping("/avaliacoes")
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@Autowired
	private SolicitacaoService solicitacaoService;
	
	@GetMapping 
	public String indexAvaliacao(Model model) {
		List<Avaliacao> lista = avaliacaoService.findAll();
		model.addAttribute("listaAvaliacao", lista);
		return "solicitacao/avaliacoes"; 
	}
	
	@GetMapping ("/avaliarSolicitacoes")
	public String indexAvaliar(Model model) {
		List<Solicitacao> lista = solicitacaoService.findAll();
		model.addAttribute("listaSolicitacao", lista);
		return "avaliacao/homeAvaliacoes"; 
	}
	
	@GetMapping("/novaAvaliacao")
	public String criar(Model model) {
		
		List<Solicitacao> listaSolicitacoes = solicitacaoService.findAll();
		model.addAttribute("solicitacoes", listaSolicitacoes);
	
		model.addAttribute("avaliacao", new Avaliacao());
		
		return "solicitacao/formAvaliacao";
	}
	
	// Envia as informacoes do formulario para a camada de servico
	@PostMapping
	public String salvar(@Valid Avaliacao avaliacao, RedirectAttributes alerta) {
		try {
			avaliacaoService.validar(avaliacao);
			avaliacaoService.existe(avaliacao);
			avaliacaoService.save(avaliacao);
			alerta.addFlashAttribute("sucesso", "Avaliação Realizada");
		} catch (BusinessException e) {
			e.printStackTrace();
			alerta.addFlashAttribute("erro", "Erro na realização da avaliação [" + e.getMessage() + "]");
			return "redirect:/solicitacoes/avaliarSolicitacoes";
		} catch (ModelException e) {
			e.printStackTrace();
			alerta.addFlashAttribute("aviso", "Avaliação já existe [" + e.getMessage() + "]");
			return "redirect:/solicitacoes/avaliarSolicitacoes";
		}
		
		return "redirect:/solicitacoes/avaliarSolicitacoes";
	}
	
//	@GetMapping("/remover/{id}")
//	public String remover(@PathVariable Integer id) {
//		if (id != null) {
//			Avaliacao avaliacao = avaliacaoService.findOne(id).get();
//			avaliacaoService.delete(avaliacao);
//		}
//		return "redirect:/avaliarSolicitacoes";
//	}
//	
//	@GetMapping("/removerSolicitacaoServico/{id}")
//	public String removerSolicitacaoServico(@PathVariable Integer id) {
//		if (id != null) {
//			Solicitacao solicitacao = solicitacaoService.findOne(id).get();
//			solicitacaoService.delete(solicitacao);
//		}
//		return "redirect:/solicitacoes/AcompanharServico";
//	}
//	
//	@GetMapping("/editar/{id}")
//	public String atualizar(@PathVariable Integer id, Model model) {
//		try {
//			if (id != null) {
//				Solicitacao solicitacao = solicitacaoService.findOne(id).get();
//				model.addAttribute("solicitacao", solicitacao);
//				List<Servico> listaServicos = servicoService.findAll();
//				model.addAttribute("servicos", listaServicos);
//				List<Status> listaStatus = statusService.findAll();
//				model.addAttribute("status", listaStatus);
//			}
//		} catch (Exception e) {
//			e.getMessage();
//		}
//		return "solicitacao/formEditarSolicitacao";
//	}
//	
//	@PutMapping
//	public String atualizar(@Valid Solicitacao solicitacao, RedirectAttributes alerta) {
//		//try {
//			//solicitacaoService.validar(solicitacao);
//			solicitacaoService.save(solicitacao);
//			alerta.addFlashAttribute("sucesso", "Solicitacao Modificada!");
////		} catch (BusinessException e) {
////			e.printStackTrace();
////			alerta.addFlashAttribute("erro", "Erro na atualizacao da residencia [" + e.getMessage() + "]");
////		} 
//		return "redirect:/solicitacoes";
//	}
//	
//	@GetMapping("/detalhes/{id}")
//	public String detalharProae(@PathVariable Integer id, Model model) {
//		try {
//			if (id != null) {
//				Solicitacao solicitacao = solicitacaoService.findOne(id).get();
//				model.addAttribute("solicitacao", solicitacao);
//			}
//		} catch (Exception e) {
//			e.getMessage();
//		}
//		return "solicitacao/detalhesSolicitacao";
//	}
}
