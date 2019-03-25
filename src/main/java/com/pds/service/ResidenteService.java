package com.pds.service;

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
}
