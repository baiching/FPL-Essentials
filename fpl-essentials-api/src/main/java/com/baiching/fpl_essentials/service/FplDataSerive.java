package com.baiching.fpl_essentials.service;

import com.baiching.fpl_essentials.model.Gameweek;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface FplDataSerive {
    List<Gameweek> getGameweekData() throws JsonProcessingException;
    Boolean lastHour(Gameweek gameweek);

    Gameweek findByGameWeek(String gameWeekName);
}
