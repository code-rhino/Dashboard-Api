package com.baron.dashboardapi.domain.chuckfacts.services;

import com.baron.dashboardapi.domain.chuckfacts.models.ChuckFact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class ChuckFactsServiceImpl implements ChuckFactsService{

    private Logger logger = LoggerFactory.getLogger(ChuckFactsServiceImpl.class);

    private RestTemplate restTemplate;

    @Value("${chuck.api.host}")
    private String host;

    @Value("${chuck.api.key}")
    private String key;

    public ChuckFactsServiceImpl(){
        this.restTemplate = new RestTemplate();
    }

    @Override
    public Optional<ChuckFact> requestDataFromApi() {
        try {
            String uri = "https://matchilling-chuck-norris-jokes-v1.p.rapidapi.com/jokes/random";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("X-RapidAPI-Host", host);
            httpHeaders.set("X-RapidAPI-Key", key);
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            ResponseEntity<ChuckFact> response = restTemplate.exchange(uri, HttpMethod.GET, entity, ChuckFact.class);
            ChuckFact fact = response.getBody();
            logger.info(fact.toString());
            return Optional.of(fact);
        }catch(HttpClientErrorException ex){
            return Optional.empty();
        }
    }
}
