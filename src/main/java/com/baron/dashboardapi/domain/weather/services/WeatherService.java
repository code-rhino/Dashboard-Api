package com.baron.dashboardapi.domain.weather.services;

import com.baron.dashboardapi.domain.weather.models.WeatherApiResponse;

import java.util.Optional;

public interface WeatherService {
    Optional<WeatherApiResponse> requestDataFromApi(String lat, String lon);
}
