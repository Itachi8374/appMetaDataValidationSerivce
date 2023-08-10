package com.appMetaDataValidationService.services;

import com.appMetaDataValidationService.helper.BundleIDValidator;
import com.appMetaDataValidationService.requestBody.AppRequest;
import com.appMetaDataValidationService.models.App;
import com.appMetaDataValidationService.models.Publisher;
import com.appMetaDataValidationService.repositories.AppRepository;
import com.appMetaDataValidationService.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppServiceImpl implements AppService {

    private final AppRepository appRepository;
    private final PublisherRepository publisherRepository;

    @Autowired
    public AppServiceImpl(AppRepository appRepository, PublisherRepository publisherRepository){
        this.appRepository = appRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<App> getApps() {
        return appRepository.findAll();
    }

    @Override
    public List <App> getAppsByPublisher(Long id) {
        Optional < Publisher> publisher = publisherRepository.findById(id);
        if(publisher.isPresent()){
            return appRepository.findByPublisher(publisher.get());
        }else{
            return List.of();
        }
    }

    @Override
    public Optional<App> getAppById(Long id) {
        return appRepository.findById(id);
    }

    @Override
    public ResponseEntity addNewApp(AppRequest appRequest) {
        //Check If Publisher Exists
        Optional <Publisher> publisher = publisherRepository.findById(appRequest.getPublisherId());
        if(publisher.isPresent()){
            BundleIDValidator validator = new BundleIDValidator();
            String validatorString = validator.bundleIdValidator(appRequest.getAppBundleId());
            if(validatorString != ""){
                App newApp = new App();
                newApp.setAppBundleID(appRequest.getAppBundleId());
                newApp.setAppName(appRequest.getAppName());
                newApp.setPublisher(publisher.get());

                appRepository.save(newApp);
                return new ResponseEntity<String>(validatorString, HttpStatus.CREATED);
            }else{
                return new ResponseEntity("Invalid Bundle ID", HttpStatus.BAD_REQUEST);
            }

        }else{
            return new ResponseEntity<String>("Publisher Not Registered", HttpStatus.UNAUTHORIZED);
        }
    }
}
