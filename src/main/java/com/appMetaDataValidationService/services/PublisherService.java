package com.appMetaDataValidationService.services;

import com.appMetaDataValidationService.models.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    public List<Publisher> getPublishers();
    public Optional<Publisher> getPublisherById(Long id);
    public Publisher registerPublisher(Publisher publisher);
}
