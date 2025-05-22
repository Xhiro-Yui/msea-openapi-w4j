package com.sleepingcats.api.endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sleepingcats.api.endpoint.handler.NexonAPIErrorHandler;
import com.sleepingcats.api.model.CharacterResponse;
import com.sleepingcats.api.model.exception.NexonAPIException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CharacterEndpoint {
    private final String baseUrl;
    private final String apiKey;
    private final HttpClient httpClient;
    private final ObjectMapper mapper;

    public CharacterEndpoint(String baseUrl, String apiKey, HttpClient httpClient, ObjectMapper mapper) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.httpClient = httpClient;
        this.mapper = mapper;
    }

    public CharacterResponse getCharacterIdentifier(String characterName) throws NexonAPIException, IOException, InterruptedException {
        String url = baseUrl + "/id?character_name=" + characterName;
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("x-nxopen-api-key", apiKey).GET().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            NexonAPIErrorHandler.handleError(response.body());
        }
        CharacterResponse responseObject = mapper.readValue(response.body(), CharacterResponse.class);
        return responseObject; // Or parse it into a POJO
    }

    public String getCharacterBasic(String ocid) throws NexonAPIException, IOException, InterruptedException {
        String url = baseUrl + "/character/basic?ocid=" + ocid;
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("x-nxopen-api-key", apiKey).GET().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            NexonAPIErrorHandler.handleError(response.body());
        }
        return response.body(); // Or parse it into a POJO
    }
}
