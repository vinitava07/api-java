package com.rpgGo.rpg_go.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "table", schema = "rpg_go")
public class RpgTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;
    @Column(name = "name")
    String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rpgTable", cascade = CascadeType.ALL)
    private List<Room> rooms;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

}
