package com.pbcompass.Projeto_WebServices_com_MongoDB.services;

import com.pbcompass.Projeto_WebServices_com_MongoDB.domain.User;
import com.pbcompass.Projeto_WebServices_com_MongoDB.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}
