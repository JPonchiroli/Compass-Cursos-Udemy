package com.pbcompass.Projeto_WebServices_com_MongoDB.services;


import com.pbcompass.Projeto_WebServices_com_MongoDB.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbcompass.Projeto_WebServices_com_MongoDB.domain.User;
import com.pbcompass.Projeto_WebServices_com_MongoDB.repositories.UserRepository;
import com.pbcompass.Projeto_WebServices_com_MongoDB.services.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User obj){
        return repository.insert(obj);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
