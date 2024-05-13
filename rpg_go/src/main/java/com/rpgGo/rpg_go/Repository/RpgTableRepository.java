package com.rpgGo.rpg_go.Repository;

import com.rpgGo.rpg_go.Models.RpgTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RpgTableRepository extends JpaRepository<RpgTable, Integer> {
}
