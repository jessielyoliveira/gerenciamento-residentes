package com.pds.service;

import java.util.List;
import java.util.Optional;

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
	public Usuario save(Usuario entity) { 
		return usuarioRepository.save(entity);
	}
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	@Transactional(readOnly=false)
	public Optional<Usuario> findOne(Integer id) {
		return usuarioRepository.findById(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Usuario entity) {
		usuarioRepository.delete(entity);
	}
}
