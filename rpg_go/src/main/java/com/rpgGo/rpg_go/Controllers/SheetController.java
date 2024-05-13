package com.rpgGo.rpg_go.Controllers;

import com.rpgGo.rpg_go.Models.Sheet;
import com.rpgGo.rpg_go.Models.User;
import com.rpgGo.rpg_go.Repository.SheetRepository;
import com.rpgGo.rpg_go.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sheet")
public class SheetController {
    @Autowired
    SheetRepository sheetRepository;
    @Autowired
    UserRepository userRepository;


    @GetMapping
    public List<Sheet> getAllSheets() {
        System.out.println(sheetRepository.findAll());
        return sheetRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sheet> findSheetById(@PathVariable("id") Integer sheetId) {
        return ResponseEntity.status(HttpStatus.OK).body(sheetRepository.findById(sheetId).get());

    }

    @PostMapping
    public ResponseEntity<Sheet> createSheet(@RequestParam(name = "user_id", required = true) Integer user_id, @RequestBody Sheet sheet) {
        User userTemp = userRepository.getById(user_id);
        sheet.setUser(userTemp);
        return ResponseEntity.status(HttpStatus.CREATED).body(sheetRepository.save(sheet));
    }

    @PutMapping
    public ResponseEntity<Sheet> editSheet(@RequestParam(name = "user_id", required = true) Integer user_id, @RequestBody Sheet sheet) {
        User userTemp = userRepository.getById(user_id);
        sheet.setUser(userTemp);
        return ResponseEntity.status(HttpStatus.CREATED).body(sheetRepository.save(sheet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSheet(@PathVariable Integer id) {
        sheetRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
