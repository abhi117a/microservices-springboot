package com.abhi.microservices.limitsservice.controller;

import com.abhi.microservices.limitsservice.configuration.ApplicationPropertiesConfig;
import com.abhi.microservices.limitsservice.entity.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author a0r00rf */
@RestController
@RequestMapping("/microservice")
public class LimitsConfigurationController {

  @Autowired private ApplicationPropertiesConfig applicationPropertiesConfig;

  @GetMapping("/limits")
  public LimitConfiguration retriveLimitsFromConfiguration() {

    return new LimitConfiguration(
        applicationPropertiesConfig.getMaximum(), applicationPropertiesConfig.getMinimum());
  }
}
