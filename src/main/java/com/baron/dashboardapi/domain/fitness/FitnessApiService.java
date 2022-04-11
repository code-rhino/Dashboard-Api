package com.baron.dashboardapi.domain.fitness;

import java.util.Optional;

public interface FitnessApiService {
    Optional<String> requestDataFromApi(Integer weight, Integer height);
}
