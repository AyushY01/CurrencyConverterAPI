package com.example.demo.Controller;

import com.example.demo.Service.DataService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/currency")
public class DataController {
    @Autowired
    private DataService ds;

    public DataController(DataService ds) {
        this.ds = ds;
    }
    @GetMapping("/convert/{from}/to/{to}/{amount}")
    public ResponseEntity<?> convert(@PathVariable String from, @PathVariable String to, @PathVariable Double amount) {
        try {
            Double result = ds.currencyconvert(from, to, amount);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Check the code is valid or not");
        }
    }

    @GetMapping("/allExchangeRate")
    public ResponseEntity<Map<String,Map<String,Double>>> getAllExchangeRate(){
            Map<String,Map<String,Double>> exchangeRate=ds.getAllRates();
            return ResponseEntity.ok(exchangeRate);
        }

}
