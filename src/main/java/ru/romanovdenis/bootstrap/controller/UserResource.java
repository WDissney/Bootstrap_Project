package ru.romanovdenis.bootstrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.romanovdenis.bootstrap.model.User;
import ru.romanovdenis.bootstrap.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public ResponseEntity<User> findById(@PathVariable Long id) {
        try {
            User user = userService.findById(id).orElseThrow();
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/users")
    @ResponseBody
    public List<User> allUsers(){
        return userService.getAllUsers();
    }


    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.removeUser(id);
        return "User id = "+id+" delete";
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user){
        userService.save(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        userService.save(user);
        return user;
    }

    @GetMapping("/auth")
    public User showAuthUser (){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }
}
