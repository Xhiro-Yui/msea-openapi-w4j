package com.sleepingcats.api.model.exception;

import com.sleepingcats.api.model.NexonAPIErrorCode;

public class InvalidCharacterNameException extends NexonAPIException {
    public InvalidCharacterNameException(NexonAPIErrorCode nexonError, String errorDescription) {
        super(nexonError, errorDescription);
    }

}
