package com.baiching.fpl_essentials.repository;

import com.baiching.fpl_essentials.model.Gameweek;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameWeekDeadlineRepository extends JpaRepository<Gameweek, Long> {
    Gameweek findByName(String name);
    Gameweek findById(int id);
    List<Gameweek> findAll();
}
