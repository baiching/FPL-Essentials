package com.baiching.fpl_essentials.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Gameweek {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String gameweekName;
    private String deadlineTime;

}
