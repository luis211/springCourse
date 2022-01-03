package com.artur.example.services;

import com.artur.example.entities.Role;
import com.artur.example.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Integer id, Role role) {
        Optional<Role> result = roleRepository.findById(id);
        if (result.isPresent()) {
            return roleRepository.save(role);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn´t exist", id));
        }
    }

    public void deleteRole(Integer id) {
        Optional<Role> result = roleRepository.findById(id);
        if (result.isPresent()) {
            roleRepository.delete(result.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn´t exist", id));
        }

    }
}
