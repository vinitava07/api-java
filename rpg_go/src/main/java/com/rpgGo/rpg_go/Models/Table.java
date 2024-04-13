package com.rpgGo.rpg_go.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;
@Entity
@jakarta.persistence.Table(name="table",schema = "rpg_go")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;
    String name;
    Integer masterId;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getMasterId() {
        return masterId;
    }
}
