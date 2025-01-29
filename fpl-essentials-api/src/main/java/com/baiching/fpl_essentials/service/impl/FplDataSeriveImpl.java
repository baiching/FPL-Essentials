package com.baiching.fpl_essentials.service.impl;

import com.baiching.fpl_essentials.model.Gameweek;
import com.baiching.fpl_essentials.repository.GameWeekDeadlineRepository;
import com.baiching.fpl_essentials.service.FplDataSerive;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@Service
public class FplDataSeriveImpl implements FplDataSerive {

    @Autowired
    private GameWeekDeadlineRepository repository;

    @Override
    public List<Gameweek> getGameweekData() throws IOException {
        URL url = new URL("https://fantasy.premierleague.com/api/bootstrap-static/");
        Gameweek gw = new Gameweek();

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {

            StringBuilder sb = new StringBuilder();
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }

            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode mainNode = objectMapper.readTree(sb.toString());
            JsonNode eventsNode = mainNode.get("events");
            List<Gameweek> gameweeks = objectMapper.readValue(eventsNode.toString(), new TypeReference<List<Gameweek>>() {});

            repository.saveAll(gameweeks);

            return gameweeks;

        } else {
            System.out.println("Error in Sending Request");
            return null;
        }
    }

    @Override
    public Boolean lastHour(Gameweek gameweek) {
        return null;
    }

    @Override
    public Gameweek findByGameWeek(String gameWeekName) {
        return repository.findByName(gameWeekName);
    }
}
