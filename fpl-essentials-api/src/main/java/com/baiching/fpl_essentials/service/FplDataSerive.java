package com.baiching.fpl_essentials.service;

import com.baiching.fpl_essentials.model.Gameweek;

import java.util.List;

public interface FplDataSerive {
    List<Gameweek> getGameweekData();
    Boolean lastHour(Gameweek gameweek);

    Gameweek findByGameWeek(String gameWeekName);
}
