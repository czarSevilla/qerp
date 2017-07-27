package com.qacg.qerp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qacg.qerp.persistence.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
