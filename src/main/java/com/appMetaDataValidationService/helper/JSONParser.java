package com.appMetaDataValidationService.helper;

import com.appMetaDataValidationService.models.Metadata;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.List;
import java.util.Arrays;

public class JSONParser {

    JSONParser(){}

    public String responseParser(String JSONString){

        Gson gson = new Gson();
        Metadata metadata = gson.fromJson(JSONString, Metadata.class);
        return metadata.toString();
    }
}
