package com.rpgGo.rpg_go.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "table", schema = "rpg_go")
public class RpgTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Integer id;

    String name;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rpgTable", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Room> rooms;


    public List<Room> getRooms() {
        return rooms;
    }

    public Integer getMasterId() {
        return user.getId();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

}
