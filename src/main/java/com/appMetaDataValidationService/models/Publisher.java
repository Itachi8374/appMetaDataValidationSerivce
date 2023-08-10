package com.appMetaDataValidationService.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.List;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(updatable = false, nullable = false)
    private long publisherId;
    private String publisherFirstName;
    private String publisherLastName;

    @OneToMany(mappedBy = "publisher")
    private List<App> apps;

    public Publisher(){

    }

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
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
