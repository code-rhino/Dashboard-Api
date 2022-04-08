package com.baron.dashboardapi.domain.weather.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
public class Wind {
    private Double speed;
    private Integer deg;
}
