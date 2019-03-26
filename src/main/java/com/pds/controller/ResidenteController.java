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
import org.springframework.web.bind.annotation.RequestParam;

import com.pds.model.Residencia;
import com.pds.model.Residente;
import com.pds.service.ResidenciaService;
import com.pds.service.ResidenteService;

@Controller
@RequestMapping("/residentes")
public class ResidenteController {
	@Autowired
	private ResidenteService residenteService;
	
	@Autowired
	private ResidenciaService residenciaService;
	

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
		List<Residencia> listaResidencias = residenciaService.findAll();
		model.addAttribute("residencias", listaResidencias);
		model.addAttribute("residente", new Residente());
		return "residente/formResidente";
	}
	
	// Envia as informacoes do formulario para a camada de servico
	@PostMapping("/novo")
	public String residenteSubmit(@ModelAttribute Residente residente) {
		residenteService.save(residente);
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
	
	//bug: se buscar mais de uma vez ele vai para o endere�o residentes/residentes/.../busca [RESOLVIDO]
	@PostMapping("/busca")
	public String buscar(Model model, @RequestParam("chave") String chave) {
		List<Residente> lista = residenteService.search(chave);
		model.addAttribute("listaResidentes", lista);
		return "residente/homeResidente"; 
	}
}
