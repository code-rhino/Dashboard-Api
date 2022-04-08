package com.baron.dashboardapi.domain.weather.controller;

import com.baron.dashboardapi.domain.weather.models.WeatherApiResponse;
import com.baron.dashboardapi.domain.weather.services.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("weather")
public class WeatherController {
    private static Logger logger = LoggerFactory.getLogger(WeatherController.class);
    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @GetMapping("")
    public ResponseEntity<WeatherApiResponse> requestWeather(@RequestParam(name="lon", required = false) String lon,
                                                             @RequestParam(name="lat", required = false) String lat) {

        Optional<WeatherApiResponse> response = weatherService.requestDataFromApi(lat, lon);
        logger.info(response.toString());
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
