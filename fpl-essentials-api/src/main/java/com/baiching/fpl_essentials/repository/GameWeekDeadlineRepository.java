package com.baiching.fpl_essentials.repository;

import com.baiching.fpl_essentials.model.Gameweek;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameWeekDeadlineRepository extends JpaRepository<Gameweek, Long> {
    Gameweek findByName(String name);
}
