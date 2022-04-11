package com.baron.dashboardapi.domain.fitness;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Log
public class FitnessServiceApiImpl implements FitnessApiService{

    private RestTemplate restTemplate;

    @Autowired
    public FitnessServiceApiImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    public void setup(){
        requestDataFromApi(60, 159);
    }

    @Override
    public Optional<String> requestDataFromApi(Integer weight, Integer height) {
        String url = "https://mega-fitness-calculator1.p.rapidapi.com/bmi?weight=%d&height=%d";
        String requestUrl = String.format(url, weight, height);
        /** Setting our headers **/
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", "mega-fitness-calculator1.p.rapidapi.com");
        headers.set("X-RapidAPI-Key", "7cc961cb7cmsh51f23a4603eb1f4p1dec01jsn726094c92c31");
        /** combine the two for request **/
        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(requestUrl, HttpMethod.GET, requestEntity,String.class);
        log.info(response.getBody());
        return Optional.empty();
    }
}
