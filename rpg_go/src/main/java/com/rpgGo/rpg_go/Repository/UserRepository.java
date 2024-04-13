package com.rpgGo.rpg_go.Repository;
import com.rpgGo.rpg_go.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> { }

