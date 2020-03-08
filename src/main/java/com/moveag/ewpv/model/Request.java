package com.moveag.ewpv.model;

import java.util.List;

/**
 * TODO use/import Lombok
 *
 * @author traychev
 */
public class Request {

  private List<List<Double>> prices;
  private List<String> date;

  public List<List<Double>> getPrices() {
    return prices;
  }

  public void setPrices(List<List<Double>> prices) {
    this.prices = prices;
  }

  public List<String> getDate() {
    return date;
  }

  public void setDate(List<String> date) {
    this.date = date;
  }
}
