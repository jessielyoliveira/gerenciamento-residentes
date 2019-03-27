package com.pds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pds.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer>{
	
	@Query("SELECT r FROM Servico r WHERE lower(r.nome) LIKE %?1%")
	List<Servico> buscaPorNome(String chave);
}
