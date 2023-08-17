package com.appMetaDataValidationService.helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import org.slf4j.LoggerFactory;

public class BundleIDValidator {
    public String bundleIdValidator(String appBundleId){
        String URL  = "http://localhost:8081";
        //String URL = "http://flask-app:8081/";
        String requestBody = "{\"app_id\":" + "\"" + appBundleId + "\"}";
        Logger log = LoggerFactory.getLogger(this.getClass());

        try{

            URL urlObj = new URL(URL);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json"); // Set content type

            // Enable input and output streams
            connection.setDoOutput(true);

            // Write JSON request body data
            try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                outputStream.writeBytes(requestBody);
                outputStream.flush();
            }

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                System.out.println("Response Body: " + response.toString());

                JSONParser jsonParser = new JSONParser();
                String filteredMetadata = jsonParser.responseParser(response.toString());

                log.info(filteredMetadata);
                return response.toString();
            }
        }catch (MalformedURLException Me){
            log.error(Me.toString());
            Me.printStackTrace();
            return "";
        }catch (IOException IO){
            log.error(IO.toString());
            IO.printStackTrace();
            return "";
        }
    }
}
