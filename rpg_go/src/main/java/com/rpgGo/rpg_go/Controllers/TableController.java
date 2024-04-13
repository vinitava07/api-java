package com.rpgGo.rpg_go.Controllers;

import com.rpgGo.rpg_go.Repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/table")
public class TableController {
    @Autowired
    TableRepository tableRepository;



}
