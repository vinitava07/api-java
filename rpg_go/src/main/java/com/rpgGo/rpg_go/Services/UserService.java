package com.rpgGo.rpg_go.Services;
import com.rpgGo.rpg_go.Models.User;
import com.rpgGo.rpg_go.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return null;
    }



    // Other business logic related to users
}