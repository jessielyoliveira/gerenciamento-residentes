package com.pds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pds.model.PROAE;
import com.pds.repository.PROAERepository;

@Service
@Transactional(readOnly=true)
public class PROAEService {
	@Autowired
	private PROAERepository proaeRepository;
	
	@Transactional(readOnly = false)
	public PROAE save(PROAE proae) {
		return proaeRepository.save(proae);
	}
}
