package com.sleepingcats.api.model.exception;

import com.sleepingcats.api.model.NexonAPIErrorCode;

public class InvalidAPIKeyException extends NexonAPIException {
    public InvalidAPIKeyException(NexonAPIErrorCode nexonError, String errorDescription) {
        super(nexonError, errorDescription);
    }

}
