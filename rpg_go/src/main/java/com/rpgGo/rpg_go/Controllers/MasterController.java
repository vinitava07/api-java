package com.rpgGo.rpg_go.Controllers;

import com.rpgGo.rpg_go.Models.Master;
import com.rpgGo.rpg_go.Repository.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/master")
public class MasterController {
    @Autowired
    MasterRepository masterRepository;
    @GetMapping()
    public ResponseEntity<List<Master>> getAllMasters() {
        return ResponseEntity.status(HttpStatus.OK).body(masterRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Master>> getMasterById(@PathVariable("masterId") Integer masterId) {
        return ResponseEntity.status(HttpStatus.OK).body(masterRepository.findById(masterId));
    }
    @PostMapping()
    public ResponseEntity<Master> createMaster(@RequestBody Master master) {
        return ResponseEntity.status(HttpStatus.CREATED).body(masterRepository.save(master));
    }

}
