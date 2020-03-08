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
    // TODO traychev add validations for the correctness of the input
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
}
