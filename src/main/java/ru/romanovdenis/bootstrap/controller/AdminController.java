package ru.romanovdenis.bootstrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import ru.romanovdenis.bootstrap.service.UserService;


@Controller
@RequestMapping("/admin")
public class AdminController {

    final private UserService userService;
    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUsers(){
        return "index";
    }

}
