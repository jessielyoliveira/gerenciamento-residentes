package com.pds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pds.model.Residencia;
import com.pds.repository.ResidenciaRepository;

@Service
@Transactional(readOnly=true)
public class ResidenciaService {
	
	@Autowired
	private ResidenciaRepository residenciaRepository;
	
	@Transactional(readOnly = false)
	public Residencia save(Residencia residencia) {
		return residenciaRepository.save(residencia);
	}
	
	public List<Residencia> findAll() {
		return residenciaRepository.findAll();
	}
	
	@Transactional(readOnly=false)
	public Optional<Residencia> findOne(Integer id) {
		return residenciaRepository.findById(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Residencia residencia) {
		residenciaRepository.delete(residencia);
	}
	
}
