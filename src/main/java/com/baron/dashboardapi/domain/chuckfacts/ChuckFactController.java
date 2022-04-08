package com.baron.dashboardapi.domain.chuckfacts;

import com.baron.dashboardapi.domain.chuckfacts.models.ChuckFact;
import com.baron.dashboardapi.domain.chuckfacts.services.ChuckFactsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("chuckfacts")
public class ChuckFactController {
    private static Logger logger = LoggerFactory.getLogger(ChuckFactController.class);

    private ChuckFactsService chuckFactsService;

    public ChuckFactController(ChuckFactsService chuckFactsService){
        this.chuckFactsService = chuckFactsService;
    }

    @GetMapping("")
    public ResponseEntity<ChuckFact> requestChuckFact(){
        Optional<ChuckFact> response = chuckFactsService.requestDataFromApi();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
