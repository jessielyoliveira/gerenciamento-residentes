package com.pds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pds.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer>{

}