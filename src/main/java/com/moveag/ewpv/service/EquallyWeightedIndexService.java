package com.moveag.ewpv.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * @author traychev
 */
@Service
public class EquallyWeightedIndexService {

  private static final double INITIAL_INVESTMENT = 1000.0;

  public Map<String, Double> calculateIndex(List<List<Double>> prices, List<String> date) {
    int N = prices.size();
    double equalAmount = INITIAL_INVESTMENT / N;
    Map<String, Double> dateToEWIdx = new HashMap<>();
    List<Double> index = new ArrayList<>();
    for (int i = 0; i < prices.size(); i++) {
      double id = equalAmount / prices.get(i).get(0);
      index.add(i, id);
    }

    for (int i = 0; i < prices.get(0).size(); i++) {
      double ewi = 0;
      for (int j = 0; j < prices.size(); j++) {
        ewi += index.get(j) * prices.get(j).get(i);
      }
      dateToEWIdx.put(date.get(i), ewi);
    }

    return dateToEWIdx;
  }

  /**
   * A second example, for:
   * [ [500, 512, 525, 510], [ 24, 25, 20, 16 ] , [ 1.0, 2.0, 3.0, 2.0 ] ]
   * and
   * [‘2020-01-06', ‘2020-01-07', ‘2020-01-08', ‘2020-01-09']
   * it should return something like:
   * {‘2020-01-06': 1000, ‘2020-01-07': 1355.22, ‘2020-01-08': 1627.78,
   * ‘2020-01-09': 1228.89 }
   */
  public static void main(String[] args) {
    EquallyWeightedIndexService tester = new EquallyWeightedIndexService();
    List<List<Double>> prices = new ArrayList<>();
    List<Double> price1 = new ArrayList<>();
    price1.add(500.0);
    price1.add(512.0);
    price1.add(525.0);
    price1.add(510.0);
    List<Double> price2 = new ArrayList<>();
    price2.add(24.0);
    price2.add(25.0);
    price2.add(20.0);
    price2.add(16.0);
    List<Double> price3 = new ArrayList<>();
    price3.add(1.0);
    price3.add(2.0);
    price3.add(3.0);
    price3.add(2.0);
    prices.add(price1);
    prices.add(price2);
    prices.add(price3);
    List<String> date = new ArrayList<>();
    date.add("1");
    date.add("2");
    date.add("3");
    date.add("4");
    tester.calculateIndex(prices, date);
  }

}
