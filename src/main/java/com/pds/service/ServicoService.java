package com.pds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pds.exception.BusinessException;
import com.pds.exception.ModelException;
import com.pds.model.Residencia;
import com.pds.model.Servico;
import com.pds.model.Status;
import com.pds.repository.ServicoRepository;

@Service
@Transactional(readOnly=true)
public class ServicoService {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	public List<Servico> findAll() {
		return servicoRepository.findAll();
	}

	public Optional<Servico> findOne(Integer id) {
		return servicoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Servico save(Servico servico) {
		return servicoRepository.save(servico);
	}	
	
	@Transactional(readOnly = false)
	public void delete(Servico entity) {
		servicoRepository.delete(entity);
	}
	
	public void existe(Servico serv) throws ModelException {
		List<Servico> servicos = findAll();	
		for (Servico servico : servicos) {
			Integer id = servico.getId();
			String nome = servico.getNome().toLowerCase();
			if(nome.equals(serv.getNome().toLowerCase())) {
				throw new ModelException("Nome ja cadastrado");
			}
			if(id.equals(serv.getId())) {
				throw new ModelException("Id ja cadastrado");
			}
		}	
		
	}
	
	public void validar(Servico servico) throws BusinessException {
		if( servico.getNome().equals("") || servico.getNome() == null){
			throw new BusinessException("Serviço inválido ou nulo");
		}
		
	}
	
	public boolean empty() {
		List<Servico> servicos = findAll();
		if(servicos.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public List<Servico> search(String chave) {
		return servicoRepository.buscaPorNome(chave);
	}
}
