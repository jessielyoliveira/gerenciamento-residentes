package com.pds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pds.model.PROAE;

@Repository
public interface PROAERepository extends JpaRepository<PROAE, Integer> {

}
