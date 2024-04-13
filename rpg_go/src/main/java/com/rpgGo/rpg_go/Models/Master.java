package com.rpgGo.rpg_go.Models;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "table_master", schema = "rpg_go")
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer masterId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
//    Integer userId;
//
//    public Integer getUserId() {
//        return userId;
//    }

    public Integer getMasterId() {
        return masterId;
    }

}
