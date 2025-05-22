package com.sleepingcats;

import com.sleepingcats.api.model.CharacterResponse;
import com.sleepingcats.api.model.exception.NexonAPIException;
import com.sleepingcats.restclient.MapleSeaAPIClient;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        MapleSeaAPIClient client = MapleSeaAPIClient.builder()
                .apiKey("test_aa89ce70c95df77bae23616db9bd7a518014ca21fa6be9af3501eb5b41724c48efe8d04e6d233bd35cf2fabdeb93fb0d")
                .build();

        try {
            CharacterResponse response = client.character().getCharacterIdentifier("CeliaYuki");
            String responseJson = client.character().getCharacterBasic(response.getOcid());
            System.out.println("");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (NexonAPIException e) {
            throw new RuntimeException(e);
        }
        System.out.println("????");
    }
}
