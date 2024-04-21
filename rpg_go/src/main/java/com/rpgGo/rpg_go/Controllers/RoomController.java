package com.rpgGo.rpg_go.Controllers;

import com.rpgGo.rpg_go.Models.Room;
import com.rpgGo.rpg_go.Models.RpgTable;
import com.rpgGo.rpg_go.Models.Sheet;
import com.rpgGo.rpg_go.Models.User;
import com.rpgGo.rpg_go.Repository.RoomRepository;
import com.rpgGo.rpg_go.Repository.RpgTableRepository;
import com.rpgGo.rpg_go.Repository.SheetRepository;
import com.rpgGo.rpg_go.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RpgTableRepository rpgTableRepository;
    @Autowired
    SheetRepository sheetRepository;

    @GetMapping
    public ResponseEntity<List<Room>> getAllUsers() {
        List<Room> list = roomRepository.findAll();
        for(Room r : list) {
            System.out.println(r.getRpgTable().getName());
        }
        return ResponseEntity.status(HttpStatus.OK).body(roomRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Room> createTable(@RequestParam(name = "table_id", required = true) Integer tableId,
                                              @RequestParam(name = "user_id", required = true) Integer userId,
                                              @RequestParam(name = "sheet_id", required = true) Integer sheetId,
                                              @RequestBody(required = true) Room room) {
        if (userRepository.existsById(userId) && rpgTableRepository.existsById(tableId)) {
            User userTemp = userRepository.getById((userId));
            RpgTable rpgTableTemp = rpgTableRepository.getById(tableId);
            Sheet sheetTemp = sheetRepository.getById(sheetId);
            room.setUser(userTemp);
            room.setRpgTable(rpgTableTemp);
            room.setSheet(sheetTemp);
            return ResponseEntity.status(HttpStatus.OK).body(roomRepository.save(room));

        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);

    }


}
