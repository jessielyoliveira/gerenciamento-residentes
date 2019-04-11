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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pds.exception.BusinessException;
import com.pds.exception.ModelException;
import com.pds.model.Residencia;
import com.pds.model.Residente;
import com.pds.service.ResidenciaService;
import com.pds.service.ResidenteService;

@Controller
@RequestMapping("/residencias")
public class ResidenciaController {

	@Autowired
	private ResidenciaService residenciaService;
	
	@Autowired
	private ResidenteService residenteService;

	@GetMapping
	public String indexResidencia(Model model) {
		List<Residencia> lista = residenciaService.findAll();
		model.addAttribute("listaResidencias", lista);
		return "residencia/homeResidencia";
	}

	@GetMapping("/nova")
	public String criar(Model model) {
		model.addAttribute("residencia", new Residencia());
		return "residencia/formResidencia";
	}

	@PostMapping
	public String salvar(@Valid Residencia residencia, RedirectAttributes alerta, Model model) {
		try {
			residenciaService.validar(residencia);
			residenciaService.existe(residencia);
			residenciaService.save(residencia);
			residenciaService.alocaQuartos(residencia);
									
			alerta.addFlashAttribute("sucesso", "Residencia inserida");
		} catch (BusinessException e) {
			e.printStackTrace();
			alerta.addFlashAttribute("erro", "Erro na insercao da residencia [" + e.getMessage() + "]");
		} catch (ModelException e) {
			e.printStackTrace();
			alerta.addFlashAttribute("aviso", "Residencia ja existe [" + e.getMessage() + "]");
		}
		return "redirect:/residencias";
	}

	@GetMapping("/remover/{id}")
	public String remover(@PathVariable Integer id) {
		if (id != null) {
			Residencia residencia = residenciaService.findOne(id).get();
			residenciaService.delete(residencia);
		}
		return "redirect:/residencias";
	}

	@GetMapping("/editar/{id}")
	public String atualizar(@PathVariable Integer id, Model model) {
		try {
			if (id != null) {
				Residencia residencia = residenciaService.findOne(id).get();
				model.addAttribute("residencia", residencia);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return "residencia/formResidencia";
	}

	/*
	 * TODO Permite editar com mesmo nome, mas se colocar a função de verificar
	 * existência não edita mais. Tentar uma solução depois.
	 */
	@PutMapping
	public String atualizar(@Valid Residencia residencia, RedirectAttributes alerta) {
		try {
			residenciaService.validar(residencia);
			residenciaService.save(residencia);
			residenciaService.alocaQuartos(residencia);
			alerta.addFlashAttribute("sucesso", "Residencia atualizada");
		} catch (BusinessException e) {
			e.printStackTrace();
			alerta.addFlashAttribute("erro", "Erro na atualizacao da residencia [" + e.getMessage() + "]");
		}
		return "redirect:/residencias";
	}
	
	@GetMapping("/detalhes/{id}")
	public String detalhar(@PathVariable Integer id, Model model) {
		try {
			if (id != null) {
				Residencia residencia = residenciaService.findOne(id).get();
				model.addAttribute("residencia", residencia);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return "residencia/detalhesResidencia";
	}

	@PostMapping("/busca")
	public String buscar(Model model, @RequestParam("chave") String chave) {
		List<Residencia> lista = residenciaService.search(chave.toLowerCase());
		model.addAttribute("listaResidencias", lista);
		return "residencia/homeResidencia";
	}

	@GetMapping("/alocar/{id}")
	public String alocarResidente(@PathVariable Integer id, Model model) {
		try {
			if (id != null) {
				Residencia residencia = residenciaService.findOne(id).get();
				List<Residente> residentes = residenteService.naoAlocados();
				model.addAttribute("residencia", residencia);
				model.addAttribute("residentes", residentes);
				
				/*
				 * ResidenteService residenteService = new ResidenteService();
				 * 
				 * List<Residente> residentesNaoAlocados = residenteService.naoAlocados();
				 * model.addAttribute("residentesNaoAlocados", residentesNaoAlocados);
				 */
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return "residencia/alocarNaResidencia";
	}
	
	@PostMapping("/alocar/{idResidencia}")
	public String alocarResidente(@PathVariable Integer idResidencia, Integer residente, 
			Integer piso, Integer quarto, RedirectAttributes alerta, Model model) {
		try {
			//Residente residente = residenteService.buscaPorMatricula(matricula);
			System.out.println("piso = " + piso );
			//residenteService.alocar(residente, matricula, idResidencia, piso, quarto);					
			alerta.addFlashAttribute("sucesso", "Residente alocado");
		} catch (Exception e) {
			e.printStackTrace();
			alerta.addFlashAttribute("erro", "Erro na alocação do residente [" + e.getMessage() + "]");
		}
		return "redirect:/residencias/alocar/" + idResidencia;
	}
	
	
//	@PostMapping("/alocar/{idResidencia}")
//	public String alocarResidente(@PathVariable Integer idResidencia, String matricula, 
//			Integer piso, Integer quarto, RedirectAttributes alerta, Model model) {
//		try {
//			Residente residente = residenteService.buscaPorMatricula(matricula);
//			System.out.println("residenteService.buscaPorMatricula(matricula) = " + residente.getNome());
//			residenteService.alocar(residente, matricula, idResidencia, piso, quarto);					
//			alerta.addFlashAttribute("sucesso", "Residente alocado");
//		} catch (Exception e) {
//			e.printStackTrace();
//			alerta.addFlashAttribute("erro", "Erro na alocação do residente [" + e.getMessage() + "]");
//		}
//		return "redirect:/residencias/alocar/" + idResidencia;
//	}
}
