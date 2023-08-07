package com.appMetaDataValidationService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
public class App {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID appID;
    private String appName;

    public UUID getAppID() {
        return appID;
    }

    public void setAppID(UUID appID) {
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

    private String appBundleID;
}
