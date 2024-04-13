package com.rpgGo.rpg_go.Models;

import java.util.UUID;

public class Sheet {

    Integer id;
    String name;
    String playerClass;
    String race;
    int playerLevel;
    String spells;
    Integer userId;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public String getRace() {
        return race;
    }

    public String getSpells() {
        return spells;
    }

    public Integer getUserId() {
        return userId;
    }
}
