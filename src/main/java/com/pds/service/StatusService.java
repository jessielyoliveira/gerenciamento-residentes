package com.pds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pds.exception.BusinessException;
import com.pds.exception.ModelException;
import com.pds.model.Servico;
import com.pds.model.Solicitacao;
import com.pds.model.Status;
import com.pds.repository.StatusRepository;


@Service
@Transactional(readOnly=true)
public class StatusService {
	@Autowired
	private StatusRepository statusRepository;
	
	public List<Status> findAll() {
		return statusRepository.findAll();
	}

	public Optional<Status> findOne(Integer id) {
		return statusRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Status save(Status status) {
		return statusRepository.save(status);
	}	
	
	@Transactional(readOnly = false)
	public void delete(Status entity) {
		statusRepository.delete(entity);
	}
	
	public void existe(Status statuss) throws ModelException{
		List<Status> Status = findAll();	
		for (Status status : Status) {
			Integer Id = status.getId();
			String nome = status.getNome();
			if(Id.equals(statuss.getId())) {
				throw new ModelException("Id ja cadastrado");
			}
			if(nome.equals(statuss.getNome().toLowerCase())) {
				throw new ModelException("Nome ja cadastrado");
			}
		}	
	}
	
	public boolean empty() {
		List<Status> status = findAll();
		if(status.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public void validar(Status status) throws BusinessException {
		if( status.getNome().equals("") || status.getNome() == null){
			throw new BusinessException("Status inválido ou nulo");
		}
		
	}
	
	public List<Status> search(String chave) {
		return statusRepository.buscaPorNome(chave);
	}
}
