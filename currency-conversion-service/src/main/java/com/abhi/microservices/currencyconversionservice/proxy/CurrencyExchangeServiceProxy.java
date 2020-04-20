package com.abhi.microservices.currencyconversionservice.proxy;

import com.abhi.microservices.currencyconversionservice.entity.CurrencyExchangeValueEntity;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/** @author a0r00rf */
// @FeignClient(name = "currency-exchange-service", url = "localhost:8000")
// @FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

  // @GetMapping("/currency-exchange/from/{from}/to/{to}")
  @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
  public ResponseEntity<CurrencyExchangeValueEntity> retriveExchangeValue(
      @PathVariable String from, @PathVariable String to);
}
