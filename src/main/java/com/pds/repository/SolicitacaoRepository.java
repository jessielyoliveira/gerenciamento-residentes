package com.pds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pds.model.Solicitacao;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Integer>{

}
