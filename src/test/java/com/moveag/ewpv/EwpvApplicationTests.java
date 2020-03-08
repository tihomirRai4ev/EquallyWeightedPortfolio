package com.moveag.ewpv;

import com.moveag.ewpv.service.EquallyWeightedIndexService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
class EwpvApplicationTests {

  private EquallyWeightedIndexService service = new EquallyWeightedIndexService();

  @Test
  public void testExpectedOutputProvided() {
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
    Map<String, Double> output = service.calculateIndex(prices, date);
    Map<String, Double> expected = new HashMap<>();
    expected.put("1", 1000d);
    expected.put("2", 1355.2222222222222d);
    expected.put("3", 1627.7777777777778d);
    expected.put("4", 1228.8888888888887d);
    assertEquals(output, expected);
  }
}
