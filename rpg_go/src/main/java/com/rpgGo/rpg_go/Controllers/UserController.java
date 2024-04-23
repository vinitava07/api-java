package com.rpgGo.rpg_go.Controllers;

//import com.rpgGo.rpg_go.Models.Master;

import com.rpgGo.rpg_go.Models.RpgTable;
import com.rpgGo.rpg_go.Models.User;
//import com.rpgGo.rpg_go.Repository.MasterRepository;
import com.rpgGo.rpg_go.Repository.RpgTableRepository;
import com.rpgGo.rpg_go.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RpgTableRepository rpgTableRepository;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(@RequestBody String nameAdm) {

        System.out.println(nameAdm);
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll(nameAdm));

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {

        return ResponseEntity.status(HttpStatus.OK).body(userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) throws NoSuchAlgorithmException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginAuth(@RequestBody User user) throws NoSuchAlgorithmException {
        User u;
        u = userService.findByName(user.getName());
        System.out.println("AAAAAAAAAAA " + u.getPassword());
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(user.getPassword().getBytes(), 0, user.getPassword().length());
        user.setPassword(new BigInteger(1, m.digest()).toString(16));

        if (Objects.equals(u.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.OK).body("{\n\t\"authorized\": \"true\"," +
                    "\n\t\"id\": " + u.getId() + "\n}");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha errados");

    }


    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) throws NoSuchAlgorithmException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}