package com.example.demo.Service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DataService {

    private static final Map<String,Map<String,Double>> data=new HashMap<>();
    static{
        Map<String, Double> fromINR = new HashMap<>();
        fromINR.put("USD", 0.012);
        fromINR.put("EUR", 0.011);
        fromINR.put("GBP", 0.0095);

        Map<String, Double> fromUSD = new HashMap<>();
        fromUSD.put("INR", 83.0);
        fromUSD.put("EUR", 0.95);
        fromUSD.put("GBP", 0.79);

        Map<String, Double> fromEUR = new HashMap<>();
        fromEUR.put("INR", 88.0);
        fromEUR.put("USD", 1.05);
        fromEUR.put("GBP", 0.85);

        data.put("INR", fromINR);
        data.put("USD", fromUSD);
        data.put("EUR", fromEUR);

    }
    public Double currencyconvert(String from, String to, Double amount) {
         //Base case
        if (!data.containsKey(from) || !data.containsKey(to)) {
            throw new IllegalArgumentException("Invalid currency code");
        }

        Double afterExchange=data.get(from).get(to);
        return amount*afterExchange;
    }

    public Map<String,Map<String,Double>> getAllRates() {
        return data;
    }
}
