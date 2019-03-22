package com.pds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pds.model.Servico;
import com.pds.repository.ServicoRepository;

@Service
@Transactional(readOnly=true)
public class ServicoService {
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Transactional(readOnly = false)
	public Servico save(Servico servico) {
		return servicoRepository.save(servico);
	}	
}
