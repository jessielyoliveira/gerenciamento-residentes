package com.pds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pds.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>{
	
	@Query("SELECT r FROM Status r WHERE lower(r.nome) LIKE %?1%")
	List<Status> buscaPorNome(String chave);
}
