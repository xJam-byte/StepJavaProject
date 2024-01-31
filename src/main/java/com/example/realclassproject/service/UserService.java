package com.example.realclassproject.service;

import com.example.realclassproject.config.SpringSecurity;
import com.example.realclassproject.dto.UserDto;
import com.example.realclassproject.entity.User;
import com.example.realclassproject.repository.RoleRepository;
import com.example.realclassproject.repository.UserRepository;
import com.example.realclassproject.config.SpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository uR, RoleRepository rR, PasswordEncoder pE){
        this.roleRepository = rR;
        this.userRepository = uR;
        this.passwordEncoder = pE;
    }
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }
    public List<User> gAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        String[] str = user.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }
    public void registerUser(UserDto dto){
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setPassword(dto.getPassword());
        userRepository.save(user);
    }

}
