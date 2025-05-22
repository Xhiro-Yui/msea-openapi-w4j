package com.sleepingcats.api.model.exception;

import com.sleepingcats.api.model.NexonAPIErrorCode;

public class ServiceUnavailableException extends NexonAPIException {
    public ServiceUnavailableException(NexonAPIErrorCode nexonError, String errorDescription) {
        super(nexonError, errorDescription);
    }

}
