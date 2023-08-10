package com.appMetaDataValidationService.services;

import com.appMetaDataValidationService.requestBody.AppRequest;
import com.appMetaDataValidationService.models.App;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AppService {
    public List<App> getApps();
    public List<App> getAppsByPublisher(Long id);
    public Optional <App> getAppById(Long id);
    public ResponseEntity addNewApp(AppRequest appRequest);
}
