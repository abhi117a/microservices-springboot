package com.abhi.microservices.currencyexchangeservice.controller;

import com.abhi.microservices.currencyexchangeservice.entity.ExchangeValue;
import com.abhi.microservices.currencyexchangeservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/** @author a0r00rf */
@RestController
public class CurrencyExchangeController {

  @Autowired private Environment environment;
  @Autowired ExchangeValueRepository exchangeValueRepository;

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ResponseEntity<ExchangeValue> retriveExchangeValue(
      @PathVariable String from, @PathVariable String to) {

    System.out.println(environment.getProperty("local.server.port"));
    ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
    exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

    return new ResponseEntity<>(exchangeValue, HttpStatus.OK);
  }
}
