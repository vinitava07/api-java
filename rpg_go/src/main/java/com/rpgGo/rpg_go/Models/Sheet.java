package com.rpgGo.rpg_go.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "sheet", schema = "rpg_go")
public class Sheet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Integer id;
    String name;
    String playerClass;
    String race;
    int playerLevel;
    String spells;
    @JsonIgnore
    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "user_id")
    User user;
    @JsonIgnore
    @OneToOne(mappedBy = "sheet")
    Room room;

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

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

}
