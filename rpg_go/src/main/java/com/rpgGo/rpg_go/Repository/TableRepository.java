package com.rpgGo.rpg_go.Repository;

import com.rpgGo.rpg_go.Models.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TableRepository extends JpaRepository<Table, Integer> {
}
