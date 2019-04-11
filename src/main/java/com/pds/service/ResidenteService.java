package com.pds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pds.exception.BusinessException;
import com.pds.exception.ModelException;
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
	
	public List<Residente> search(String key) {
		return residenteRepository.buscarPorNomeOuMatricula(key);
	}
	
	public List<Residente> naoAlocados() {
		return residenteRepository.selectResidentesNaoAlocados();
	}
	
	@Transactional(readOnly=false)
	public void delete(Residente entity) {
		residenteRepository.delete(entity);
	}
	
	public void validate(Residente residente) throws BusinessException {
		if(residente.getNome().equals("") || residente.getNome() == null){
			throw new BusinessException("Nome inválido ou nulo");
		}
		
		if(residente.getMatricula() == null || residente.getMatricula() < 1000000000){
			throw new BusinessException("Matrícula inválida");
		}
		
		if(residente.getCPF() == null || residente.getCPF() < 10000000){
			throw new BusinessException("CPF inválido");
		}
	}
	
	public void alreadyExists(Residente residente) throws ModelException {
		Residente r = residenteRepository.buscarPorMatricula(residente.getMatricula());
		
		if(r != null) {
			throw new ModelException("Matrícula " + r.getMatricula() + " já está cadastrado");
		}

		r = residenteRepository.buscarPorCPF(residente.getCPF());
		
		if(r != null) {
			throw new ModelException("CPF " + r.getCPF() + " já está cadastrado");
		}
	}
	
	
}
