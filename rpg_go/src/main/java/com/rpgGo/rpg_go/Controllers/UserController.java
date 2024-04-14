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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RpgTableRepository rpgTableRepository;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        User user = userService.getById((id));
        System.out.println();
        System.out.println(user.getRpgTableList());
        System.out.println();
        return ResponseEntity.status(HttpStatus.OK).body(userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

//    @PostMapping("/newMaster")
//    public ResponseEntity<User> newMaster(@RequestParam(name = "user_id") Integer userId, @RequestBody(required = true) RpgTable rpgTable) {
//        System.out.println("CRIANDO UM NOVO MESTRE PARA A SALA");
//        System.out.println(userId);
//        User userTemp = userService.getById((userId));
//        List<RpgTable> rpgTables = new ArrayList<>();
//        rpgTable.setUser(userTemp);
//        rpgTables.add(rpgTable);
//        userTemp.setListRpgTable(rpgTables);
////        userService.save(userTemp);
//
//        return ResponseEntity.status(HttpStatus.OK).body(userService.save(userTemp));
//    }


}