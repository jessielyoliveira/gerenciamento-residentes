package com.pds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pds.exception.BusinessException;
import com.pds.exception.ModelException;
import com.pds.model.Avaliacao;
import com.pds.repository.AvaliacaoRepository;

@Service
@Transactional(readOnly=true)
public class AvaliacaoService {
	
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Transactional(readOnly = false)
	public Avaliacao save(Avaliacao avaliacao) {
		return avaliacaoRepository.save(avaliacao);
	}
	
	public List<Avaliacao> findAll() {
		return avaliacaoRepository.findAll();
	}
	
	public Optional<Avaliacao> findOne(Integer id) {
		return avaliacaoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public void delete(Avaliacao entity) {
		avaliacaoRepository.delete(entity);
	}
	
	public void existe(Avaliacao avali) throws ModelException {
		List<Avaliacao> avaliacoes  = findAll();	
		for (Avaliacao avaliacao : avaliacoes) {
			Integer Id = avaliacao.getId();
			if(Id.equals(avali.getId())) {
				throw new ModelException("Id ja cadastrado");
			}
		}	
	}
	
	public void validar(Avaliacao avaliacao) throws BusinessException {
		if( avaliacao.getGrauSatisfacaoSolicitacao().equals("") || avaliacao.getGrauSatisfacaoSolicitacao() == null){
			throw new BusinessException("Grau de satisfaçao inválido ou nulo");
		}
		
		if( avaliacao.getComentarioSolicitacao().equals("") ||  avaliacao.getComentarioSolicitacao() == null){
			throw new BusinessException("Comentário inválido ou nulo");
		}
		
		if( avaliacao.getNotaFuncionario().equals("") || avaliacao.getNotaFuncionario() == null){
			throw new BusinessException("Nota inválida ou nulo");
		}
		
		if( avaliacao.getComentarioFuncionario().equals("") ||  avaliacao.getComentarioFuncionario() == null){
			throw new BusinessException("Comentário inválido ou nulo");
		}
		
		
	}
}
