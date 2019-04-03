package com.pds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pds.exception.ModelException;
import com.pds.model.Residencia;
import com.pds.model.Solicitacao;
import com.pds.repository.SolicitacaoRepository;

@Service
@Transactional(readOnly=true)
public class SolicitacaoService {
	@Autowired
	private SolicitacaoRepository solicitacaoRepository;
	
	@Transactional(readOnly = false)
	public Solicitacao save(Solicitacao solicitacao) {
		return solicitacaoRepository.save(solicitacao);
	}
	
	public List<Solicitacao> findAll() {
		return solicitacaoRepository.findAll();
	}
	
	public Optional<Solicitacao> findOne(Integer id) {
		return solicitacaoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public void delete(Solicitacao entity) {
		solicitacaoRepository.delete(entity);
	}
	
	public void existe(Solicitacao solic) throws ModelException {
		List<Solicitacao> solicitacoes = findAll();	
		for (Solicitacao solicitacao : solicitacoes) {
			Integer Id = solicitacao.getId();
			if(Id.equals(solic.getId())) {
				throw new ModelException("Id ja cadastrado");
			}
		}	
	}
	
//	public List<Solicitacao> search(String chave) {
//		return solicitacaoRepository.buscaPorNome(chave);
//	}
}
