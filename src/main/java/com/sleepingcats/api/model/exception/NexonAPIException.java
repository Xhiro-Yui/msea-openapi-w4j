package com.sleepingcats.api.model.exception;

import com.sleepingcats.api.model.NexonAPIErrorCode;
import lombok.Getter;

@Getter
public class NexonAPIException extends Exception {
    /**
     * Error codes returned by Nexon Open API
     *
     * @see <a href="https://openapi.nexon.com/support/faq/2588916/">Nexon Open API Error Codes</a>
     */
    private final String nexonErrorCode;
    private final String nexonErrorDescription;
    private final int code;

    /**
     * Nexon API Exception.
     * @param nexonError mapped error
     * @param errorMessage error message retrieved from response body
     */
    public NexonAPIException(NexonAPIErrorCode nexonError, String errorMessage) {
        super(nexonError.getResponseDescription());
        this.nexonErrorDescription = errorMessage;
        this.nexonErrorCode = nexonError.name();
        this.code = nexonError.getResponseCode();
    }

    public NexonAPIException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.nexonErrorCode = null;
        this.nexonErrorDescription = null;
        this.code = errorCode;
    }

}
