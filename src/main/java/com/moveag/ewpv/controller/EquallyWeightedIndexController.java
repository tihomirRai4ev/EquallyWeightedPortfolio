package com.moveag.ewpv.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moveag.ewpv.model.Request;
import com.moveag.ewpv.service.EquallyWeightedIndexService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/v1")
public class EquallyWeightedIndexController {

  private EquallyWeightedIndexService equallyWeightedIndexService;
  private ObjectMapper mapper = new ObjectMapper();

  @Autowired
  public EquallyWeightedIndexController(EquallyWeightedIndexService service) {
    this.equallyWeightedIndexService = service;
  }

  @PostMapping(path = "/calculateIndex", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> processJobExecution(@RequestBody Request request) {
    try {
      Map<String, Double> res = equallyWeightedIndexService
          .calculateIndex(request.getPrices(), request.getDate());
      return ResponseEntity.ok(mapper.writeValueAsString(res));
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
          e.getMessage(), e);
    }
  }
}
