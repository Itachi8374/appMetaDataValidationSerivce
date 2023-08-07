package com.appMetaDataValidationService.services;

import com.appMetaDataValidationService.models.Publisher;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface PublisherService {
    public List<Publisher> getPublishers();
    public Publisher getPublisherById(UUID id);
    public ResponseEntity registerPublisher(Publisher publisher);
}
