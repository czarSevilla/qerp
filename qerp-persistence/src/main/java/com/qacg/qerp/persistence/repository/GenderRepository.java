package com.qacg.qerp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qacg.qerp.persistence.entity.Gender;

public interface GenderRepository extends JpaRepository<Gender, Long>{

}
