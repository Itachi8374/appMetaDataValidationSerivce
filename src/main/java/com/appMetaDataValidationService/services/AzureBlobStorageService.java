package com.appMetaDataValidationService.services;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.stereotype.Service;

@Service
public class AzureBlobStorageService {

    String sas_token = "";
    public void uploadFileLocally(){
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .endpoint("")
                .sasToken(sas_token)
                .buildClient();
        String  containerName = "metadatavalidation";
        BlobContainerClient  containerClient = blobServiceClient.getBlobContainerClient(containerName);
        //Locally running path
        String local_file_path = "/Users/tanay.maheshwari/appMetaDataValidationService/logs/app-meta-data.log";
        //Kubernetes running path
        //String local_file_path = "/Users/tanay.maheshwari/appMetaDataValidationService/logs/app-meta-data.log";
        BlobClient blobClient = containerClient.getBlobClient("app-meta-data.log");
        blobClient.uploadFromFile(local_file_path,true);
    }
}