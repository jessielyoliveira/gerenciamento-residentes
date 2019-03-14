package com.pds.service;

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

}
