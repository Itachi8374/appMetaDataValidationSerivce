package com.appMetaDataValidationService.helper;

import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrometheusQuery {
    public String prometheusQuery (String metric) throws IOException, InterruptedException {
        String queryURL = "http://localhost:9090/api/v1/query?query=" + metric;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(queryURL))
                .GET().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String responseBody = response.body();
            System.out.println(responseBody); // Print the Prometheus query response
        } else {
            System.err.println("Request failed: " + response.statusCode() + " " + response.body());
        }

        return response.body();
    }
}
