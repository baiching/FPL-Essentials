package com.baiching.fpl_essentials.controller;

import com.baiching.fpl_essentials.model.EmailDetails;
import com.baiching.fpl_essentials.model.Gameweek;
import com.baiching.fpl_essentials.service.FplDataSerive;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class FplDataController {
    @Autowired
    FplDataSerive dataSerive;

    @GetMapping("/seeData")
    public List<Gameweek> getData() throws IOException {
        return dataSerive.getGameweekData();
    }
}
