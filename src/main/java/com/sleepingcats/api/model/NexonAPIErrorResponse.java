package com.sleepingcats.api.model;

public class NexonAPIErrorResponse {
    private ErrorDetail error;

    public ErrorDetail getError() {
        return error;
    }

    public void setError(ErrorDetail error) {
        this.error = error;
    }
}
