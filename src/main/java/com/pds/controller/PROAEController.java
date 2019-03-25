package com.pds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pds.model.PROAE;
import com.pds.model.Residencia;
import com.pds.service.PROAEService;
import com.pds.service.ResidenciaService;

@Controller
@RequestMapping("/proae")
public class PROAEController {
	
	@Autowired
	private PROAEService proaeService;
	
	@GetMapping
	public String homePROAE() {
		return "proae/portal_proae";
	}
	
	/*
	 * // Abre o formulario de cadastro de funcionario da proae
	 * 
	 * @GetMapping("/novo") public String cadastrarPROAE() { return
	 * "proae/cadastrarProae"; }
	 * 
	 * // Envia as informacoes do formulario para a camada de servico e direciona
	 * para a index
	 * 
	 * @PostMapping("/novo") public String cadastrarPROAE(PROAE proae) {
	 * proaeService.save(proae); return "redirect:/"; }
	 * 
	 * // Abre o formulario de login de funcionario da proae
	 * 
	 * @GetMapping("/entrar") public String logarPROAE() { return
	 * "proae/loginPROAE"; }
	 * 
	 * // Abre a tela de inicio de funcionario da proae
	 * 
	 * @GetMapping("/inicio") public String inicioPROAE() { return
	 * "proae/inicioPROAE"; }
	 * 
	 * // Abre a tela de gerencia de residentes
	 * 
	 * @GetMapping("/gerir-residentes") public String gerirResidentes() { return
	 * "proae/gerirResidentes"; }
	 * 
	 * // Abre a tela de gerencia de residentes
	 * 
	 * @GetMapping("/cadastrar-residente") public String cadastrarResidente() {
	 * return "proae/cadastroResidente"; }
	 */
}
