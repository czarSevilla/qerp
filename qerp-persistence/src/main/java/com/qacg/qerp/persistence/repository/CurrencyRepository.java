package com.qacg.qerp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qacg.qerp.persistence.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}
