package com.pbcompass.Projeto_WebServices_com_MongoDB.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbcompass.Projeto_WebServices_com_MongoDB.domain.Post;
import com.pbcompass.Projeto_WebServices_com_MongoDB.repositories.PostRepository;
import com.pbcompass.Projeto_WebServices_com_MongoDB.services.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll(){
        return repository.findAll();
    }

    public Post findById(String id){
        Optional<Post> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text){
        return repository.searchTitle(text);
    }

}
