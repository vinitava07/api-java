package com.rpgGo.rpg_go.Services;

import com.rpgGo.rpg_go.Models.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();

    List<User> findAll(String nameAdm);

    User getById(Integer id);
    User update(User user);
    void deleteById(Integer id);
    User findByName(String name);

}
