package com.pds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pds.model.Status;
import com.pds.repository.StatusRepository;


@Service
@Transactional(readOnly=true)
public class StatusService {
	@Autowired
	private StatusRepository statusRepository;
	
	@Transactional(readOnly = false)
	public Status save(Status status) {
		return statusRepository.save(status);
	}	
}
