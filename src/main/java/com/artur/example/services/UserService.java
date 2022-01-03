package com.artur.example.services;

import com.artur.example.entities.User;
import com.artur.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public Page<User> getUsers(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public Page<String> getUsernames(int page, int size) {
        return repository.findUsernames(PageRequest.of(page, size));
    }

    public User getUserById(Integer id) {
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %d not found")));
    }

    public User getUserByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User %s not found", username))
        );
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        return repository.findByUsernameAndPassword(username, password).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User or password not valid"))
        );
    }
}
