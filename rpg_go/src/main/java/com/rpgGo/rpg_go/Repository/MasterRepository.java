package com.rpgGo.rpg_go.Repository;

import com.rpgGo.rpg_go.Models.Master;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MasterRepository extends JpaRepository<Master, Integer> {


}
