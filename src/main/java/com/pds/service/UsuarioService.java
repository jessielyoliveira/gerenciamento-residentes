package com.pds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pds.repository.UsuarioRepository;
import com.pds.model.Usuario;

@Service
@Transactional(readOnly=true)
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional(readOnly = false)
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
}
