package com.baron.dashboardapi.domain.weather.models;

import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Coordinate {
    @NonNull
    private Double lon;
    @NonNull
    private Double lat;
}
