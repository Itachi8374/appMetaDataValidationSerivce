package com.appMetaDataValidationService.models;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Metadata {

    private String appId;
    private String date;
    private String time;
    private String url;
    private String title;
    private String summary;
    private Double score;
    private String released;
    private BigInteger realInstalls;
    private Long ratings;
    private Long reviews;
    private Long minInstalls;
    private String genreId;

    Metadata(){
        this.date = LocalDate.now().toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        this.time = LocalTime.now().format(formatter);
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public BigInteger getRealInstalls() {
        return realInstalls;
    }

    public void setRealInstalls(BigInteger realInstalls) {
        this.realInstalls = realInstalls;
    }

    public Long getRatings() {
        return ratings;
    }

    public void setRatings(Long ratings) {
        this.ratings = ratings;
    }

    public Long getReviews() {
        return reviews;
    }

    public void setReviews(Long reviews) {
        this.reviews = reviews;
    }

    public Long getMinInstalls() {
        return minInstalls;
    }

    public void setMinInstalls(Long minInstalls) {
        this.minInstalls = minInstalls;
    }

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        return "{" +
                "appId='" + appId + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", score=" + score +
                ", released='" + released + '\'' +
                ", realInstalls=" + realInstalls +
                ", ratings=" + ratings +
                ", reviews=" + reviews +
                ", minInstalls=" + minInstalls +
                ", genreId='" + genreId + '\'' +
                '}';
    }
}
