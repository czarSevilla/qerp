package com.qacg.qerp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qacg.qerp.persistence.entity.SecUser;

public interface SecUserRepository extends JpaRepository<SecUser, Long> {

}
