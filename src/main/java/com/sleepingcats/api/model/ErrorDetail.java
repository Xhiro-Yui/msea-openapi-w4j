package com.sleepingcats.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ErrorDetail {
    @JsonProperty("name")
    private NexonAPIErrorCode errorCode;
    private String message;
}
