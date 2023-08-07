package com.appMetaDataValidationService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID publisherId;
    private String publisherFirstName;
    private String publisherLastName;

    public Publisher(){

    }

    public UUID getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(UUID publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherFirstName() {
        return publisherFirstName;
    }

    public void setPublisherFirstName(String publisherFirstName) {
        this.publisherFirstName = publisherFirstName;
    }

    public String getPublisherLastName() {
        return publisherLastName;
    }

    public void setPublisherLastName(String publisherLastName) {
        this.publisherLastName = publisherLastName;
    }
}
