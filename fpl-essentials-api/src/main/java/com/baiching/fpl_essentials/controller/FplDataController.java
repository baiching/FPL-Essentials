package com.baiching.fpl_essentials.controller;

import com.baiching.fpl_essentials.model.EmailDetails;
import com.baiching.fpl_essentials.model.Gameweek;
import com.baiching.fpl_essentials.service.FplDataSerive;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

@RestController
public class FplDataController {
    @Autowired
    FplDataSerive dataSerive;

    @GetMapping("/seeData")
    public List<Gameweek> getData() throws IOException {
        return dataSerive.getGameweekData();
    }

    @GetMapping("/seeGameweek/{id}")
    public Gameweek getData(@PathVariable("id") int id) throws IOException {
        return dataSerive.getDataByGameweek(id);
    }
}
