package com.pbcompass.Projeto_WebServices_com_MongoDB.repositories;

import com.pbcompass.Projeto_WebServices_com_MongoDB.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
}
