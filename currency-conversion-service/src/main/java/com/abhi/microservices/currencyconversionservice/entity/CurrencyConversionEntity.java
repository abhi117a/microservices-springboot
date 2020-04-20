package com.abhi.microservices.currencyconversionservice.entity;

import java.math.BigDecimal;

/** @author a0r00rf */
public class CurrencyConversionEntity {

  private Long id;
  private String from;
  private String to;
  private BigDecimal conversionMultiple;
  private BigDecimal quantity;
  private BigDecimal totalCalculateAmount;
  private int port;

  public CurrencyConversionEntity() {}

  public CurrencyConversionEntity(
      Long id,
      String from,
      String to,
      BigDecimal conversionMultiple,
      BigDecimal quantity,
      BigDecimal totalCalculateAmount,
      int port) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionMultiple = conversionMultiple;
    this.quantity = quantity;
    this.totalCalculateAmount = totalCalculateAmount;
    this.port = port;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public BigDecimal getConversionMultiple() {
    return conversionMultiple;
  }

  public void setConversionMultiple(BigDecimal conversionMultiple) {
    this.conversionMultiple = conversionMultiple;
  }

  public BigDecimal getQuantity() {
    return quantity;
  }

  public void setQuantity(BigDecimal quantity) {
    this.quantity = quantity;
  }

  public BigDecimal getTotalCalculateAmount() {
    return totalCalculateAmount;
  }

  public void setTotalCalculateAmount(BigDecimal totalCalculateAmount) {
    this.totalCalculateAmount = totalCalculateAmount;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }
}
