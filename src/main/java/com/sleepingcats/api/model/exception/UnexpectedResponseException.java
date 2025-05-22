package com.sleepingcats.api.model.exception;

/**
 * Response body from Nexon Open API is unreadable
 */
public class UnexpectedResponseException extends NexonAPIException {
    public UnexpectedResponseException(int code, String message) {
        super(code, message);
    }

}
