package com.sleepingcats.restclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sleepingcats.api.endpoint.CharacterEndpoint;
import lombok.Builder;

import java.net.http.HttpClient;
import java.time.Duration;

@Builder
public class MapleSeaAPIClient {
    /**
     * HTTP Client to send API calls to Nexon API. Defaults to {@link HttpClient} with a 10 seconds timeout if not provided to the builder.
     */
//    @SuppressWarnings("FieldCanBeLocal")
    @Builder.Default
    private final HttpClient httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
    //    private final HttpClient httpClient;
    private final String apiKey;
    private final String baseUrl = "https://open.api.nexon.com/maplestorysea/v1";
    private final ObjectMapper mapper = new ObjectMapper();

    private CharacterEndpoint character = null;


//    @Builder
//    public MapleSeaAPIClient(String apiKey, HttpClient httpClient) {
//        String baseUrl = "https://open.api.nexon.com";
//        HttpClient client = httpClient != null ? httpClient : this.httpClient;
//
//        this.character = new CharacterEndpoint(apiKey, baseUrl, client);
////        this.union = new UnionAPI(this.apiKey, this.baseUrl, this.httpClient);
//    }

    /**
     * Character Information Retrieval
     */
    public CharacterEndpoint character() {
        if (character == null) {
            character = new CharacterEndpoint(this.baseUrl, this.apiKey, this.httpClient, mapper);
        }
        return character;
    }
}
