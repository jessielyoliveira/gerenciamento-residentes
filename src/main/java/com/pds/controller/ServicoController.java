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
import com.pds.model.Servico;
import com.pds.service.ServicoService;

@Controller
@RequestMapping("/servicos")
public class ServicoController {
	
	@Autowired
	private ServicoService servicoService;
	private RedirectAttributes addFlashAttribute;
	
	
	@GetMapping
	public String indexServico(Model model) {
		List<Servico> lista = servicoService.findAll();
		model.addAttribute("listaServicos", lista);
		return "servico/homeServico"; 
	}
	
	// Abre o formulario de cadastro de servico
	@GetMapping("/novo")
	public String criar(Model model) {
		model.addAttribute("servico", new Servico());
		return "servico/formServico";
	}
	
	// Envia as informacoes do formulario para a camada de servico
	@PostMapping
	public String salvar(@Valid Servico servico, RedirectAttributes alerta) {
		try {
			//servicoService.validar(servico);
			servicoService.existe(servico);
			servicoService.save(servico);
			alerta.addFlashAttribute("sucesso", "Servico inserido");
//		} catch (BusinessException e) {
//			e.printStackTrace();
//			alerta.addFlashAttribute("erro", "Erro na insercao do servico [" + e.getMessage() + "]");
		} catch (ModelException e) {
			e.printStackTrace();
			alerta.addFlashAttribute("aviso", "Servico ja existe [" + e.getMessage() + "]");
		}
		return "redirect:/servicos";
	}
	
	@GetMapping("/remover/{id}")
	public String remover(@PathVariable("id") Integer id) {
		if (id != null) {
			Servico servico = servicoService.findOne(id).get();
			servicoService.delete(servico);
		}
		return "redirect:/servicos";
	}
	
	@GetMapping("/editar/{id}")
	public String atualizar(@PathVariable Integer id, Model model) {
		try {
			if (id != null) {
				Servico servico = servicoService.findOne(id).get();
				model.addAttribute("servico", servico);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return "servico/formServico";
	}
	
	@PutMapping
	public String atualizar(@Valid Servico servico, RedirectAttributes alerta) {
		//try {
			//servicoService.validar(servico);
			servicoService.save(servico);
			alerta.addFlashAttribute("sucesso", "Servico atualizado");
//		} catch (BusinessException e) {
//			e.printStackTrace();
//			alerta.addFlashAttribute("erro", "Erro na atualizacao do servico [" + e.getMessage() + "]");
//		} 
		return "redirect:/servicos";
	}
	
	@GetMapping("/detalhes/{id}")
	public String detalhar(@PathVariable Integer id, Model model) {
		try {
			if (id != null) {
				Servico servico = servicoService.findOne(id).get();
				model.addAttribute("servico", servico);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return "servico/detalhesServico";
	}
	
	@PostMapping("/busca")
	public String buscar(Model model, @RequestParam("chave") String chave) {
		List<Servico> lista = servicoService.search(chave.toLowerCase());
		model.addAttribute("listaServicos", lista);
		return "servico/homeServico"; 
	}
	
}
