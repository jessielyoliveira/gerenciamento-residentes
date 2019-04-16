package com.pds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pds.model.Quartos;
import com.pds.repository.QuartosRepository;

@Service
@Transactional(readOnly = true)
public class QuartosService {

	@Autowired
	private QuartosRepository quartosRepository;

	@Transactional(readOnly = false)
	public Quartos save(Quartos quarto) {	
		return quartosRepository.save(quarto);
	}

	public List<Quartos> findAll() {
		return quartosRepository.findAll();
	}

	public Optional<Quartos> findOne(String id) {
		return quartosRepository.findById(id);
	}

	@Transactional(readOnly = false)
	public void delete(Quartos quarto) {
		quartosRepository.delete(quarto);
	}
}
