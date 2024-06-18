package com.linkc.linkcbackend.services;

import com.linkc.linkcbackend.controllers.UserController;
import com.linkc.linkcbackend.domain.SendDeviceRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${IOT_API_URL}")
    private String iotURL;

    public void sendToDevice(SendDeviceRequest sendDeviceRequest) {
        logger.info("url :: " + iotURL);
        ResponseEntity response = restClient.post()
                .uri(iotURL)
                .contentType(APPLICATION_JSON)
                .body(sendDeviceRequest)
                .retrieve()
                .body(ResponseEntity.class);

        logger.info(response.toString());
    }
}
