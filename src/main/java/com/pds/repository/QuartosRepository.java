package com.pds.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pds.model.Quartos;

@Repository
@Transactional
public interface QuartosRepository extends JpaRepository<Quartos, String> {

}
