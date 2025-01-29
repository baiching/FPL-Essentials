package com.baiching.fpl_essentials.service;

import com.baiching.fpl_essentials.model.Gameweek;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface FplDataSerive {
    List<Gameweek> getGameweekData() throws IOException;
    Boolean lastHour(Gameweek gameweek);

    Gameweek findByGameWeek(String gameWeekName);
}
