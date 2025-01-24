package com.baiching.fpl_essentials.controller;

import com.baiching.fpl_essentials.model.EmailDetails;
import com.baiching.fpl_essentials.service.FplDataSerive;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FplDataController {
    @Autowired
    FplDataSerive dataSerive;

    @PostMapping("/seeData")
    public String getData() throws JsonProcessingException {
        dataSerive.getGameweekData();

        return "hello";
    }
}
