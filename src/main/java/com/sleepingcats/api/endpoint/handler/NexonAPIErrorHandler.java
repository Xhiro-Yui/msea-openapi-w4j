package com.sleepingcats.api.endpoint.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sleepingcats.api.model.NexonAPIErrorCode;
import com.sleepingcats.api.model.exception.*;

public class NexonAPIErrorHandler {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void handleError(String body) throws NexonAPIException {
        try {
            JsonNode root = mapper.readTree(body);
            JsonNode error = root.get("error");

            if (error == null) {
                throw new UnexpectedResponseException(500, body);
            }

            NexonAPIErrorCode code = error.has("name") ? NexonAPIErrorCode.fromCode(error.get("name").asText()) : null;
            String message = error.has("message") ? error.get("message").asText() : error.asText();

            if (code != null) {
                switch (code) {
                    case OPENAPI00001 -> throw new NexonAPIException(code, message);
                    case OPENAPI00002 -> throw new UnauthorizedException(code, message);
                    case OPENAPI00003 -> throw new InvalidCharacterIdentifierException(code, message);
                    case OPENAPI00004 -> throw new InvalidCharacterNameException(code, message);
                    case OPENAPI00005 -> throw new InvalidAPIKeyException(code, message);
                    case OPENAPI00006 -> throw new InvalidPathException(code, message);
                    case OPENAPI00007 -> throw new RateLimitExceededException(code, message);
                    case OPENAPI00009 -> throw new NexonAPIException(code, message);
                    case OPENAPI00010, OPENAPI00011 -> throw new ServiceUnavailableException(code, message);
                }
            }
            throw new UnexpectedResponseException(500, body);
        } catch (JsonProcessingException e) {
            throw new MalformedResponseException(500, e.getMessage());
        }
    }
}
