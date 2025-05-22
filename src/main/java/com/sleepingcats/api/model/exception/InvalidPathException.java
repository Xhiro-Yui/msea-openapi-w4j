package com.sleepingcats.api.model.exception;

import com.sleepingcats.api.model.NexonAPIErrorCode;

public class InvalidPathException extends NexonAPIException {
    public InvalidPathException(NexonAPIErrorCode nexonError, String errorDescription) {
        super(nexonError, errorDescription);
    }

}
