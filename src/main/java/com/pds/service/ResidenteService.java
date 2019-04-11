package com.pds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pds.exception.BusinessException;
import com.pds.exception.ModelException;
import com.pds.model.Residencia;
import com.pds.model.Residente;
import com.pds.repository.ResidenciaRepository;
import com.pds.repository.ResidenteRepository;

@Service
@Transactional(readOnly=true)
public class ResidenteService {
	@Autowired
	private ResidenteRepository residenteRepository;
	
	@Autowired
	private ResidenciaRepository residenciaRepository;
	
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
			throw new BusinessException("Nome inv�lido ou nulo");
		}
		
		if(residente.getMatricula() == null || residente.getMatricula() < 1000000000){
			throw new BusinessException("Matr�cula inv�lida");
		}
		
		if(residente.getCPF() == null || residente.getCPF() < 10000000){
			throw new BusinessException("CPF inv�lido");
		}
	}
	
	public void alreadyExists(Residente residente) throws ModelException {
		Residente r = residenteRepository.buscarPorMatricula(residente.getMatricula());
		
		if(r != null) {
			throw new ModelException("Matr�cula " + r.getMatricula() + " j� est� cadastrado");
		}

		r = residenteRepository.buscarPorCPF(residente.getCPF());
		
		if(r != null) {
			throw new ModelException("CPF " + r.getCPF() + " j� est� cadastrado");
		}
	}
	
	public void alocar(Residente residente, Long matricula, Integer idResidencia, Integer piso, Integer quarto) {
		Residencia residencia = residenciaRepository.findById(idResidencia).get();
		System.out.println(residente);
		//TODO Retornando null, arrumar
		residente = residenteRepository.buscarPorMatricula(matricula);
		
		System.out.println(residente);
		residente.setResidencia(residencia);
		residente.setPiso(piso);
		residente.setQuarto(quarto);
	}
	 
	
}
