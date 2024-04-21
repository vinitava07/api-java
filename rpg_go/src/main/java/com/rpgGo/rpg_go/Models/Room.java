package com.rpgGo.rpg_go.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jdk.dynalink.linker.support.CompositeGuardingDynamicLinker;

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
    @JsonIgnore
    User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "table_id")
            @JsonIgnore
    RpgTable rpgTable;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sheet_id")
    Sheet sheet;


//    String

    public RpgTable getRpgTable() {
        return rpgTable;
    }

    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRpgTable(RpgTable rpgTable) {
        this.rpgTable = rpgTable;
    }

    public String getTableName() {
        return rpgTable.getName();
    }

    public Integer getTableId() {
        return rpgTable.getId();
    }

    public Integer getSheetId() {
        return sheet.getId();
    }

    public Integer getUserId() {
        return user.getId();
    }

    public void setUser(User user) {
        this.user = user;
    }

}
