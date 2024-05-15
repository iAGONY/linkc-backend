package com.linkc.linkcbackend.services;

import com.linkc.linkcbackend.controllers.UserController;
import com.linkc.linkcbackend.domain.SendDeviceRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class AzureService {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    private RestClient restClient;

    public AzureService() {
        this.restClient = RestClient.create();
    }

    private final String URL = "https://iotfunctions.azurewebsites.net/api/SendToDevice?code=Zg78UfP0bPj1V3LBosT2hQh8PIOHhYcoNo41uAdWrgqoAzFuGDBXBg%3D%3D";

    public void sendToDevice(SendDeviceRequest sendDeviceRequest) {
        ResponseEntity response = restClient.post()
                .uri(URL)
                .contentType(APPLICATION_JSON)
                .body(sendDeviceRequest)
                .retrieve()
                .body(ResponseEntity.class);

        logger.info(response.toString());
    }
}
