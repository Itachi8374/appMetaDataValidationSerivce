package com.appMetaDataValidationService.controllers;

import com.appMetaDataValidationService.RequestBody.AppRequest;
import com.appMetaDataValidationService.models.App;
import com.appMetaDataValidationService.repositories.AppRepository;
import com.appMetaDataValidationService.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/app/")
public class AppController {
    private final AppService appService;

    @Autowired
    public AppController(AppService appService){
        this.appService = appService;
    }

    @GetMapping
    public List<App> getApps(){
        return appService.getApps();
    }

    @PostMapping
    public ResponseEntity addNewApp(@RequestBody AppRequest appRequest){
        return appService.addNewApp(appRequest);
    }

    @GetMapping("{publisherId}")
    public List<App> getAppsByPublisherID(@PathVariable Long publisherId){
        return appService.getAppsByPublisher(publisherId);
    }
}
