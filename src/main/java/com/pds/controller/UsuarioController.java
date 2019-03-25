package com.pds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pds.model.Usuario;
import com.pds.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	// Abre o formulario de cadastro de usuarios
	@GetMapping("/novo")
	public String cadastrarUsuario() {
		return "usuario/cadastroUsuario";
	}
	
	// Envia as informacoes do formulario para a camada de servico e direciona para a index
	@PostMapping("/novo")
	public String cadastrarUsuario(Usuario usuario) {
		usuarioService.save(usuario);
		return "redirect:/";
	}
	
	// Fazer login depois
	@PostMapping("/login")
	public String loginUsuario() {
		return "";
	}
}
