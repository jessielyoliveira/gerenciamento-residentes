package com.pds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pds.model.Residente;
import com.pds.repository.ResidenteRepository;

@Service
@Transactional(readOnly=true)
public class ResidenteService {
	@Autowired
	private ResidenteRepository residenteRepository;
	
	@Transactional(readOnly = false)
	public Residente save(Residente residente) {
		return residenteRepository.save(residente);
	}
	
	public List<Residente> findAll() {
		return residenteRepository.findAll();
	}
	
	public Optional<Residente> findOne(Integer id) {
		return residenteRepository.findById(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Residente entity) {
		residenteRepository.delete(entity);
	}
}
