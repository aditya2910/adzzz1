package com.sb.ss.sd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sb.ss.sd.model.RegisterDto;
import com.sb.ss.sd.repo.RegisterRepository;
import com.sb.ss.sd.repo.RegisterdUsers;

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