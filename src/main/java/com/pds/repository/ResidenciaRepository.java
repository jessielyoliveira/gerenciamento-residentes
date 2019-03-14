package com.pds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pds.model.Residencia;

@Repository
public interface ResidenciaRepository extends JpaRepository<Residencia, Integer>{

}
