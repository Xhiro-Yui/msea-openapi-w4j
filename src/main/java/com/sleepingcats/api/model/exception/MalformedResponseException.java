package com.sleepingcats.api.model.exception;

/**
 * Response body from Nexon Open API is unreadable
 */
public class MalformedResponseException extends NexonAPIException {
    public MalformedResponseException(int code, String message) {
        super(code, message);
    }

}
