package com.appMetaDataValidationService.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.UUID;

@Entity
public class App {
    @Id
    @GeneratedValue(generator = "app-sequence-generator")
    @GenericGenerator(
            name = "app-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "app-sequence_name", value = "app_sequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(updatable = false, nullable = false)
    private Long appID;
    private String appName;
    private String appBundleID;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public Long getAppID() {
        return appID;
    }

    public void setAppID(Long appID) {
        this.appID = appID;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppBundleID() {
        return appBundleID;
    }

    public void setAppBundleID(String appBundleID) {
        this.appBundleID = appBundleID;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
