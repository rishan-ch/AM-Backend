package com.asset.controller;

import com.asset.DTO.LoginCredentials;
import com.asset.model.User;
import com.asset.service.implementation.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImplementation userService;

    @PostMapping("/addUser")
    public ResponseEntity<String> addStudent(@RequestBody User user){
        userService.addUser(user);
        System.out.println("user added");
        return new ResponseEntity<>("user added", HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        userService.deleteUser(id);
        System.out.println("user deleted");
        return new ResponseEntity<>("user deleted", HttpStatus.CREATED);
    }

    @PostMapping("/editUser/{id}")
    //gets user info for updating
    public User getUserInfo(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PutMapping("/updateUser")
    //updates user
    public ResponseEntity<String> updateUser(@RequestBody User user){
        userService.updateUser(user);
        System.out.println("user updated");
        return new ResponseEntity<>("user updated", HttpStatus.CREATED);
    }

    @PostMapping("/allUser")
    public ResponseEntity<List> allStudent(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody LoginCredentials LoginCredentials){
        User user = userService.verifyUser(LoginCredentials.getEmail(),LoginCredentials.getPassword());
        System.out.println("email = "+user.getEmail());
        if(user!=null){
            return new ResponseEntity<>("User verified. email = " + user.getEmail(),HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("User not found",HttpStatus.ACCEPTED);

    }

}
