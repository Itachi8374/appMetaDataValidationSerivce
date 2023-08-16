package com.appMetaDataValidationService.helper;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;

public class BundleIDValidator {
    public String bundleIdValidator(String appBundleId){
        String URL = "http://flask-app:8081/";
        String requestBody = "{\"app_id\":" + "\"" + appBundleId + "\"}";

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
                return response.toString();
            }
        }catch (MalformedURLException Me){
            Me.printStackTrace();
            return "";
        }catch (IOException IO){
            IO.printStackTrace();
            return "";
        }
    }
}
