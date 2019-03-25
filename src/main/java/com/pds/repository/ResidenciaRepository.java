package com.pds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pds.model.Residencia;

@Repository
public interface ResidenciaRepository extends JpaRepository<Residencia, Integer> {
	
	@Query("SELECT r FROM Residencia r WHERE r.nome =:nome")
	public List<Residencia> buscaPorNome(@Param("nome") String nome);
	
}
