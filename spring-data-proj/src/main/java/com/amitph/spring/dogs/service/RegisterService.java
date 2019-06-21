package com.amitph.spring.dogs.service;

import com.amitph.spring.dogs.model.RegisterDto;
import com.amitph.spring.dogs.repo.RegisterdUsers;
import com.amitph.spring.dogs.repo.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RegisterService {
    @Autowired RegisterRepository repository;

    public void add(RegisterDto dto) {
        repository.save(toEntity(dto));
    }



    private RegisterdUsers toEntity(RegisterDto dto) {
        RegisterdUsers entity = new RegisterdUsers();
        
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setAddress(dto.getAddress());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        
        return entity;
    }
}