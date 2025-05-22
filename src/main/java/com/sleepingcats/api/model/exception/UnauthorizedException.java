package com.sleepingcats.api.model.exception;

import com.sleepingcats.api.model.NexonAPIErrorCode;

public class UnauthorizedException extends NexonAPIException {
    public UnauthorizedException(NexonAPIErrorCode nexonError, String errorDescription) {
        super(nexonError, errorDescription);
    }

}
