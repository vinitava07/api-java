package com.rpgGo.rpg_go.Services;

import com.rpgGo.rpg_go.Models.User;
import com.rpgGo.rpg_go.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findAll(String nameAdm) {
        if (nameAdm.contains("vini")) {
            return userRepository.findAll();
        }
        return null;
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}
