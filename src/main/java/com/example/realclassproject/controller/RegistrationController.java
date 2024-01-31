package com.example.realclassproject.controller;


import com.example.realclassproject.dto.UserDto;
import com.example.realclassproject.entity.User;
import com.example.realclassproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.realclassproject.service.RegisterService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public String showRegistrationForm(Model model){
        UserDto dto = new UserDto();
        model.addAttribute("user", dto);
        return "register";
    }
    @PostMapping("/save")
    public String registerUser(@ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.registerUser(userDto);
        return "redirect:/login";
    }
}
