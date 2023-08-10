package com.appMetaDataValidationService.requestBody;

public class AppRequest {

    private String appName;
    private String appBundleId;
    private Long publisherId;

    public AppRequest(){

    }
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppBundleId() {
        return appBundleId;
    }

    public void setAppBundleId(String appBundleId) {
        this.appBundleId = appBundleId;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }
}
