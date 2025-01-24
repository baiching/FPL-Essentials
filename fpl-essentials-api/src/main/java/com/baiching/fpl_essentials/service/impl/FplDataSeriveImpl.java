package com.baiching.fpl_essentials.service.impl;

import com.baiching.fpl_essentials.model.Gameweek;
import com.baiching.fpl_essentials.repository.GameWeekDeadlineRepository;
import com.baiching.fpl_essentials.service.FplDataSerive;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FplDataSeriveImpl implements FplDataSerive {

    @Autowired
    private GameWeekDeadlineRepository repository;

    @Override
    public List<Gameweek> getGameweekData() throws JsonProcessingException {
        String url = "https://fantasy.premierleague.com/api/bootstrap-static/";
        Gameweek gw = new Gameweek();

        ObjectMapper mapper = new ObjectMapper();
        gw.setDeadlineTime(mapper.readTree(url).findValue("deadline_time").toString());
        gw.setGameweekName(mapper.readTree(url).findValue("name").toString());

        repository.save(gw);
        System.out.println(gw.getDeadlineTime());
        //List<Gameweek> data =  jsonNode.get("events").get("name").get("deadline_time");

        return List.of();
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
