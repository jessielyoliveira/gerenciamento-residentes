package com.pds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pds.model.Residente;

@Repository
public interface ResidenteRepository extends JpaRepository<Residente, Integer> {

}
