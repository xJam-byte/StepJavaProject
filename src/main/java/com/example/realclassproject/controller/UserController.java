package com.example.realclassproject.controller;


import com.example.realclassproject.dto.UserDto;
import com.example.realclassproject.dto.UserLoginDto;
import com.example.realclassproject.entity.User;
import com.example.realclassproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public String users(Model model){
        model.addAttribute("users", userService.gAllUsers());
        return "users";
    }

    @PostMapping("/update")
    public String updateUser(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "updateUser";
    }
    @PostMapping("/deleteUser")
    public String showDeleteUser(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "deleteUser";
    }

    @PostMapping("/deleteUser/ok")
    public String deleteUser(UserLoginDto dto){
        return "sdfsdf";
    }


}
