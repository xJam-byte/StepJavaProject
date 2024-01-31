package com.example.realclassproject.controller;

import com.example.realclassproject.dto.UserDto;
import com.example.realclassproject.dto.UserLoginDto;
import com.example.realclassproject.entity.User;
import com.example.realclassproject.repository.UserRepository;
import com.example.realclassproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    private UserRepository userRepository;
    @GetMapping()
    public String login(Model model){
        UserLoginDto dto = new UserLoginDto();
        model.addAttribute("loguser", dto);
        return "login";
    }

    @PostMapping("/check")
    public String check(@ModelAttribute("loguser") UserLoginDto dto, BindingResult result, Model model){
        User user = userRepository.findByEmail(dto.getEmail());
        if(user.getPassword() == dto.getPassword()){
            return "redirect:/users";
        }
        return "redirect:/login";
    }
}
