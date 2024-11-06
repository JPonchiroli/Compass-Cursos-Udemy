package com.pbcompass.Projeto_WebServices_com_MongoDB.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pbcompass.Projeto_WebServices_com_MongoDB.domain.Post;
import com.pbcompass.Projeto_WebServices_com_MongoDB.services.PostService;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findAll(){
        List<Post> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
