package com.pds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public boolean existe(Solicitacao solic) {
		List<Solicitacao> solicitacoes = findAll();	
		for (Solicitacao solicitacao : solicitacoes) {
			Integer Id = solicitacao.getId();
			if(Id.equals(solic.getId())) {
				return true;
			}
		}	
		return false;
	}
}
