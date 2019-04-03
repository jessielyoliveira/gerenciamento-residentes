package com.pds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pds.model.Solicitacao;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Integer>{
	
//	@Query("SELECT s FROM Solicitacao s WHERE lower(s.nome) LIKE %?1%")
//	List<Solicitacao> buscaPorNome(String chave);
}
