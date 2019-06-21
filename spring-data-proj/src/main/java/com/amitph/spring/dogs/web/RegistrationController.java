package com.amitph.spring.dogs.web;

import com.amitph.spring.dogs.model.RegisterDto;
import com.amitph.spring.dogs.repo.RegisterdUsers;
import com.amitph.spring.dogs.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    @Autowired RegisterService service;

    @PostMapping
    public void registerUser(@RequestBody RegisterDto dto) {
        service.add(dto);
    }
}