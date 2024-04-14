package com.rpgGo.rpg_go.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "room", schema = "rpg_go")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "table_id")
    RpgTable rpgTable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRpgTable(RpgTable rpgTable) {
        this.rpgTable = rpgTable;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
