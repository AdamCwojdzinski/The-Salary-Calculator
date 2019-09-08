package com.summer.learning.controllers;

import com.summer.learning.models.Exchangerate;
import com.summer.learning.models.Rate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Controller
public class ExchangerateController {
    
    
    public List<Exchangerate> getMapCurrencyList(){
        final String uri = "http://api.nbp.pl/api/exchangerates/tables/a/";
        RestTemplate restTemplate = new RestTemplate();
    
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
    
        ResponseEntity<List<Exchangerate>> result2 = restTemplate.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Exchangerate>>() {
        });
        List<Exchangerate> exchangerates = result2.getBody();
        return exchangerates;
    }

    public Rate getRateByCurrencyCode(@RequestParam("code") String code){
        final String uri = "http://api.nbp.pl/api/exchangerates/rates/a/{code}/";
    
        Map<String, String> params = new HashMap<String, String>();
        params.put("code", code);
        RestTemplate restTemplate = new RestTemplate();
        Exchangerate result = restTemplate.getForObject(uri, Exchangerate.class, params);
    
        List<Rate> rates = result.getRates();
        Rate rate = rates.stream()
                         .findFirst()
                         .get();
        System.out.println(rate);
        System.out.println(rate.getMid());
        return rate;
    }
    
}
