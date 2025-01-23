package com.baiching.fpl_essentials.service.impl;

import com.baiching.fpl_essentials.model.Gameweek;
import com.baiching.fpl_essentials.repository.GameWeekDeadlineRepository;
import com.baiching.fpl_essentials.service.FplDataSerive;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FplDataSeriveImpl implements FplDataSerive {

    @Autowired
    private GameWeekDeadlineRepository repository;

    @Override
    public List<Gameweek> getGameweekData() {
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
