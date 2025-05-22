package com.sleepingcats.api.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Mapping for Nexon Open API Error Codes.
 *
 * @see <a href="https://openapi.nexon.com/support/faq/2588916/">Nexon Open API Error Codes</a>
 */
@Getter
public enum NexonAPIErrorCode {
    OPENAPI00001(500, "Internal Server Error", "Internal Server Error"),
    OPENAPI00002(403, "Forbidden", "Unauthorized access"),
    OPENAPI00003(400, "Bad Request", "Invalid identifier"),
    OPENAPI00004(400, "Bad Request", "Character not found"),
    OPENAPI00005(400, "Bad Request", "Invalid API key"),
    OPENAPI00006(400, "Bad Request", "Invalid game or API path"),
    OPENAPI00007(429, "Too Many Requests", "API call limit exceeded"),
    OPENAPI00009(400, "Bad Request", "Service under maintenance"),
    OPENAPI00010(400, "Bad Request", "Service under maintenance"),
    OPENAPI00011(503, "Service Unavailable", "API under maintenance"),
    ;
    private final int responseCode;
    private final String responseName;
    /**
     * Inferred error message. May not be accurate
     */
    private final String responseDescription;

    NexonAPIErrorCode(int responseCode, String responseName, String responseDescription) {
        this.responseCode = responseCode;
        this.responseName = responseName;
        this.responseDescription = responseDescription;
    }

    private static final Map<String, NexonAPIErrorCode> errorCodeMap = Arrays.stream(values())
            .collect(Collectors.toMap(Enum::name, Function.identity()));

    public static NexonAPIErrorCode fromCode(String code) {
        return errorCodeMap.get(code);
    }
}
