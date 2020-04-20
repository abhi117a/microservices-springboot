package com.abhi.microservices.currencyconversionservice.controller;

import com.abhi.microservices.currencyconversionservice.entity.CurrencyConversionEntity;
import com.abhi.microservices.currencyconversionservice.entity.CurrencyExchangeValueEntity;
import com.abhi.microservices.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/** @author a0r00rf */
@RestController
public class CurrencyConversionController {

  @Autowired CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

  @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
  public ResponseEntity<Object> getConverCurrency(
      @PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("from", from);
    uriVariables.put("to", to);

    ResponseEntity<CurrencyExchangeValueEntity> currencyConversionEntityResponse =
        new RestTemplate()
            .getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyExchangeValueEntity.class,
                uriVariables);

    CurrencyConversionEntity currencyConversionEntity = new CurrencyConversionEntity();

    currencyConversionEntity.setFrom(currencyConversionEntityResponse.getBody().getFrom());
    currencyConversionEntity.setTo(currencyConversionEntityResponse.getBody().getTo());
    currencyConversionEntity.setConversionMultiple(
        currencyConversionEntityResponse.getBody().getConversionMultiple());
    currencyConversionEntity.setQuantity(quantity);
    currencyConversionEntity.setTotalCalculateAmount(
        currencyConversionEntity.getConversionMultiple().multiply(quantity));
    currencyConversionEntity.setId(currencyConversionEntityResponse.getBody().getId());
    currencyConversionEntity.setPort(currencyConversionEntityResponse.getBody().getPort());

    return new ResponseEntity<>(currencyConversionEntity, HttpStatus.OK);
  }

  @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
  public ResponseEntity<Object> getConverCurrencyFeign(
      @PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

    ResponseEntity<CurrencyExchangeValueEntity> currencyConversionEntityResponse =
        currencyExchangeServiceProxy.retriveExchangeValue(from, to);

    CurrencyConversionEntity currencyConversionEntity = new CurrencyConversionEntity();

    currencyConversionEntity.setFrom(currencyConversionEntityResponse.getBody().getFrom());
    currencyConversionEntity.setTo(currencyConversionEntityResponse.getBody().getTo());
    currencyConversionEntity.setConversionMultiple(
        currencyConversionEntityResponse.getBody().getConversionMultiple());
    currencyConversionEntity.setQuantity(quantity);
    currencyConversionEntity.setTotalCalculateAmount(
        currencyConversionEntity.getConversionMultiple().multiply(quantity));
    currencyConversionEntity.setId(currencyConversionEntityResponse.getBody().getId());
    currencyConversionEntity.setPort(currencyConversionEntityResponse.getBody().getPort());

    return new ResponseEntity<>(currencyConversionEntity, HttpStatus.OK);
  }
}
