package com.pds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pds.model.Residente;

@Repository
@Transactional
public interface ResidenteRepository extends JpaRepository<Residente, Integer> {
	
	@Query("SELECT r FROM Residente r WHERE lower(r.nome) LIKE %?1% OR lower(r.matricula) LIKE %?1%")
	List<Residente> buscarPorNomeOuMatricula(String chave);
}
	