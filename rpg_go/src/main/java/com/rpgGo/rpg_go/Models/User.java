package com.rpgGo.rpg_go.Models;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user", schema = "rpg_go")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;
    String name;
    String password;

    @OneToMany(mappedBy = "user")
    private List<Master> listMaster = new ArrayList<>();

    private User() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Integer getId() {
        return id;
    }
}
