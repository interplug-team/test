package com.example.jpamybatis.controller;


import com.example.jpamybatis.dto.UserRecord;
import com.example.jpamybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserRecord> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/user")
    public void addUser(@RequestBody UserRecord userRecord) {
        userService.addUser(userRecord);
    }

    @GetMapping("/user/{id}")
    public UserRecord getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/user/mybatis/{id}")
    public UserRecord getUserMybatis(@PathVariable Long id) {
        return userService.getUserMybatis(id);
    }

    @PostMapping("/user/mybatis")
    public void addUserMybatis(@RequestBody UserRecord userRecord) throws Exception {
        userService.addUserMybatis(userRecord);
    }
}
