package com.rpgGo.rpg_go.Controllers;


import com.rpgGo.rpg_go.Models.RpgTable;
import com.rpgGo.rpg_go.Models.User;
import com.rpgGo.rpg_go.Repository.RpgTableRepository;
import com.rpgGo.rpg_go.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/table")
public class RpgTableController {
    @Autowired
    RpgTableRepository tableRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<RpgTable>> getAllTables() {
        return ResponseEntity.status(HttpStatus.OK).body(tableRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<RpgTable>> getTableById(@PathVariable(name = "id") Integer tableId) {
        return ResponseEntity.status(HttpStatus.OK).body(tableRepository.findById(tableId));

    }

    @PostMapping
    public ResponseEntity<RpgTable> createTable(@RequestParam(name = "master_id", required = true) Integer masterId, @RequestBody(required = true) RpgTable table) {
        if (userRepository.existsById(masterId)) {
            User userTemp = userRepository.getById((masterId));

            table.setUser(userTemp);
            tableRepository.save(table);
            return ResponseEntity.status(HttpStatus.CREATED).body(table);

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


}
