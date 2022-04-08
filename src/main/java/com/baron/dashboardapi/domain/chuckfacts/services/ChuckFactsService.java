package com.baron.dashboardapi.domain.chuckfacts.services;

import com.baron.dashboardapi.domain.chuckfacts.models.ChuckFact;

import java.util.Optional;

public interface ChuckFactsService {
    Optional<ChuckFact> requestDataFromApi();
}
