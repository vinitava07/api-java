package com.rpgGo.rpg_go.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

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
    String attack;
    String inventory;
    String skills;
    String features;
    String tools;
    String spells;
    int playerLevel;
    int health;
    int strength;
    int intelligence;
    int dexterity;
    int constitution;
    int wisdom;
    int charisma;
    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
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

    public int getCharisma() {
        return charisma;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getHealth() {
        return health;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getWisdom() {
        return wisdom;
    }

    public String getAttack() {
        return attack;
    }

    public String getFeatures() {
        return features;
    }

    public String getInventory() {
        return inventory;
    }

    public String getSkills() {
        return skills;
    }

    public String getTools() {
        return tools;
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
