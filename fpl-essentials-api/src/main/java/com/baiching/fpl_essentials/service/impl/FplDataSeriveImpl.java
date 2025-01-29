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
    public Boolean getGameweekData() throws IOException {
        URL url = new URL("https://fantasy.premierleague.com/api/bootstrap-static/");
        Gameweek gw = new Gameweek();

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        System.out.println("Response code: "+ responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {

            StringBuilder sb = new StringBuilder();
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }
            //System.out.println(sb);

            ObjectMapper objectMapper = new ObjectMapper();

            //HashMap<String, Gameweek> map = objectMapper.readValue()
            //Gameweek[] gameweeks = objectMapper.readValue(String.valueOf(sb), new TypeReference<Gameweek[]>(){});

            JsonNode mainNode = objectMapper.readTree(sb.toString());
            JsonNode eventsNode = mainNode.get("events");
            List<Gameweek> gameweeks = objectMapper.readValue(eventsNode.toString(), new TypeReference<List<Gameweek>>() {});

            System.out.println(gameweeks);

            return true;

        } else {
            System.out.println("Error in Sending Request");
            return false;
        }

//        repository.save(gw);
//        System.out.println(gw.getDeadlineTime());
        //List<Gameweek> data =  jsonNode.get("events").get("name").get("deadline_time");

        //return true;
    }

    @Override
    public Boolean lastHour(Gameweek gameweek) {
        return null;
    }

    @Override
    public Gameweek findByGameWeek(String gameWeekName) {
        return repository.findByGameweek(gameWeekName);
    }
}
