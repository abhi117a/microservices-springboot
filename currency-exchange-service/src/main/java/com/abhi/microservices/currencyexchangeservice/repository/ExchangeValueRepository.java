package com.abhi.microservices.currencyexchangeservice.repository;

import com.abhi.microservices.currencyexchangeservice.entity.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

/** @author a0r00rf */
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
  ExchangeValue findByFromAndTo(String from, String to);
}
