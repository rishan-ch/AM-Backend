package com.asset.service;

import com.asset.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
    List<User> getAllUser();
    User verifyUser(String email, String password);
}
