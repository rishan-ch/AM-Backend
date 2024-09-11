package com.asset.service.implementation;

import com.asset.model.User;
import com.asset.repository.UserRepository;
import com.asset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepo;
    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public User getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUser() {

        return userRepo.findAll();
    }

    @Override
    public User verifyUser(String email, String password) {
        return userRepo.findByEmailAndPassword(email,password);
    }
}
