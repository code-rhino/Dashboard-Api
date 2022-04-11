package com.baron.dashboardapi.domain.weather.services;

import com.baron.dashboardapi.domain.weather.models.WeatherApiResponse;
import com.baron.dashboardapi.domain.weather.models.WeatherMain;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService{
    private RestTemplate template;

    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherServiceImpl(){
        template = new RestTemplate();
    }


    @Override
    public Optional<WeatherApiResponse> requestDataFromApi(String lat, String lon) {
        try {
            String url = "https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s&units=imperial";
            String requestUrl = String.format(url, lat, lon, apiKey);
            ResponseEntity<JsonNode> response = template.exchange(requestUrl, HttpMethod.GET, null, JsonNode.class);
            //WeatherApiResponse apiResponse = response.getBody();
            JsonNode rootNode = response.getBody();
            JsonNode mainNode = rootNode.get("main");
            ObjectMapper mapper = new ObjectMapper();
            WeatherMain main = mapper.convertValue(mainNode, WeatherMain.class);
            log.info("This is main objects temp {}", main.getTemp());
            return Optional.empty();
        }catch (HttpClientErrorException ex){
            log.error(ex.getMessage());
            return Optional.empty();
        }
    }
}
