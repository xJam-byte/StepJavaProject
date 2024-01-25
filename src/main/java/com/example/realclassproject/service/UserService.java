package com.example.realclassproject.service;

import com.example.realclassproject.repository.RoleRepository;
import com.example.realclassproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository uR, RoleRepository rR){
        this.roleRepository = rR;
        this.userRepository = uR;
    }

}
