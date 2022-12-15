package com.m2i.FilRouge.service;

import com.m2i.FilRouge.entity.User;
import com.m2i.FilRouge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> getAllUsers(){
        return repo.findAll();
    }

    public Optional<User> getUserById(Long id){
        return repo.findById(id);
    }

    public User addUser(User user){
        return repo.save(user);
    }

    public void deleteUser(Long id){
        repo.findById(id).orElse(null);
        repo.deleteById(id);
    }

    public User updateUser(User user){
        User newUser = repo.findById(user.getId()).orElse(null);
        if(newUser != null){
            newUser.setEmail(user.getEmail());
            newUser.setUsername(user.getUsername());
            newUser.setPassword(user.getPassword());
            repo.save(newUser);
        }
        return newUser;
    }
}
