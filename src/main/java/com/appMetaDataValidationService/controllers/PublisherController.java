package com.appMetaDataValidationService.controllers;

import com.appMetaDataValidationService.models.Publisher;
import com.appMetaDataValidationService.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/publisher/")
public class PublisherController {
    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService){
        this.publisherService = publisherService;
    }

    @GetMapping
    public List<Publisher> getPublishers(){
        return publisherService.getPublishers();
    }

    @PostMapping
    public ResponseEntity addPublisher(@RequestBody Publisher publisher){
        Publisher savedPublisher = publisherService.registerPublisher(publisher);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("{publisherId}")
    public Optional<Publisher> getPublisherById(@PathVariable Long publisherId){
        Optional<Publisher> publisher = publisherService.getPublisherById(publisherId);
        return publisher;
    }
}
