package com.rpgGo.rpg_go.Repository;

import com.rpgGo.rpg_go.Models.Sheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SheetRepository extends JpaRepository<Sheet, Integer> {
}
