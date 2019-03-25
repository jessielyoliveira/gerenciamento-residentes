package com.pds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pds.model.Residencia;

@Repository
@Transactional
public interface ResidenciaRepository extends JpaRepository<Residencia, Integer> {
	
	@Query("SELECT r FROM Residencia r WHERE lower(r.nome) LIKE %?1%")
	List<Residencia> buscaPorNome(String chave);
	
}
