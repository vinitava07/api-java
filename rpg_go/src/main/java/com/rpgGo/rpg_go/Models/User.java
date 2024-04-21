package com.rpgGo.rpg_go.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "User")
@Table(name = "user", schema = "rpg_go")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Integer id;
    String name;
    String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<RpgTable> rpgTableList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Room> rooms;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Sheet> sheets;

    public User() {
    }

    public List<Sheet> getSheets() {
        return sheets;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<RpgTable> getRpgTableList() {
        if (this.rpgTableList != null) {
            List<RpgTable> tmpList = new ArrayList<>();
            RpgTable tmpTable = new RpgTable();
            for (RpgTable table : this.rpgTableList) {
                tmpTable.setUser(table.getUser());
                tmpTable.setId(table.getId());
                tmpTable.setName(table.getName());
                tmpList.add(tmpTable);
            }
            return tmpList;
        }
        return null;
    }

    public void setListRpgTable(List<RpgTable> rpgTableList) {
        this.rpgTableList = rpgTableList;
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

