package com.linkc.linkcbackend.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SendDeviceRequest {

    private String deviceId;
    private String command;
}
