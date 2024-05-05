package com.rpgGo.rpg_go.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "room", schema = "rpg_go")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Integer id;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    User user;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "table_id")
    @JsonIgnore
    RpgTable rpgTable;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sheet_id", referencedColumnName = "id")
    Sheet sheet;

    String sheetName;
//    String

    public RpgTable getRpgTable() {
        return rpgTable;
    }

    public String getSheetName() {
        return sheet.getName();
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

    public Sheet getSheet() {
        return sheet;
    }

    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }

    public User getUser() {
        return user;
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
