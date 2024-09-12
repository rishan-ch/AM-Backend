package com.asset.controller;

import com.asset.DTO.LoginCredentials;
import com.asset.model.User;
import com.asset.service.implementation.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* every actions related to user
* user registration, login, delete, user's info retrieve, user detail update
*
*
* */

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceImplementation userService;

    @PostMapping("/addUser")
    public ResponseEntity<String> addStudent(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>("user added", HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        userService.deleteUser(id);
        return new ResponseEntity<>("user deleted", HttpStatus.OK);
    }

    @PostMapping("/userInfo/{id}")
    //gets user info for updating
    public ResponseEntity<User> getUserInfo(@PathVariable int id){
        User user = userService.getUserById(id);
        if(user!=null){
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateUser")
    //updates user
    public ResponseEntity<String> updateUser(@RequestBody User user){
        userService.updateUser(user);
        System.out.println("user updated");
        return new ResponseEntity<>("user updated", HttpStatus.CREATED);
    }

    @PostMapping("/allUser")
    public ResponseEntity<List<User>> allStudent(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody LoginCredentials loginCredentials){
        User user = userService.verifyUser(loginCredentials.getEmail(),loginCredentials.getPassword());
        if(user!=null){
            return new ResponseEntity<>("User verified. email = " + user.getEmail(),HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Invalid Credentials",HttpStatus.NOT_FOUND);

    }

}
