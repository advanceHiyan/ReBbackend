package com.readbook.readbookbackend.controller;

import com.readbook.readbookbackend.pojo.User;
import com.readbook.readbookbackend.service.port.UserService;
import com.readbook.readbookbackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/users/signup", method = RequestMethod.POST)
    public Result signUp(String username, String password, String email,Integer user_role) {
        return userService.signUp(username, password, email,user_role);
    }

    @PostMapping("/users/login")
    public Result login(String username, String password) {
        System.out.println("login with username:"+username);
        System.out.println("login with password:"+password);
        return userService.login(username, password);
    }

    @PostMapping("/users/update_password")
    public Result updatePassword(BigInteger userid, String cur_password,
                                 String new_password, String confirm_password) {
        return userService.updatePassword(userid, cur_password, new_password, confirm_password);
    }

    @PostMapping("/users/update_email")
    public Result updateEmail(BigInteger userid,String cur_password,String new_email) {
        return userService.updateEmail(userid, cur_password, new_email);
    }

    @GetMapping(value = "/users/getall")
    public Result getAllUsers() {
        return userService.getAllUsers();
    }
}
