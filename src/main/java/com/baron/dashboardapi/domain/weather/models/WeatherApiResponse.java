package com.baron.dashboardapi.domain.weather.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class WeatherApiResponse {
    @JsonIgnore
    private Long id;
    private Coordinate coord;
    private List<Weather> weather;
    private String base;
    private Integer visibility;
    private WeatherMain main;
    private Wind wind;
    private Cloud clouds;
    private Long dt;
    private WeatherSys sys;
    private Long timezone;
    private String name;
    private Integer cod;
}
