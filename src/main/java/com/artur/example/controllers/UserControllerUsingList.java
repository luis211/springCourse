package com.artur.example.controllers;

import com.artur.example.models.User;
import com.artur.example.services.UserServiceUsingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Definicion de mi recurso
@RequestMapping("/list/users")
public class UserControllerUsingList {
    @Autowired
    private UserServiceUsingList userServiceUsingList;

    @GetMapping
    //Metodo HTTP + Recurso -> Handle method
    public ResponseEntity<List<User>> getUsers(@RequestParam(value = "startWith",required = false) String startWith) {
        return new ResponseEntity<>(userServiceUsingList.getUsers(startWith), HttpStatus.OK);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
        return new ResponseEntity<>(userServiceUsingList.getUserByUsername(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userServiceUsingList.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<User> updateUser(@PathVariable("username") String username, @RequestBody User user) {
        return new ResponseEntity<>(userServiceUsingList.updateUser(user, username), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable("username") String username) {
        userServiceUsingList.deleteUser(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
