package com.baiching.fpl_essentials.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Gameweek {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameId;

    private int id;
    private String name;
    private String deadline_time;

}
