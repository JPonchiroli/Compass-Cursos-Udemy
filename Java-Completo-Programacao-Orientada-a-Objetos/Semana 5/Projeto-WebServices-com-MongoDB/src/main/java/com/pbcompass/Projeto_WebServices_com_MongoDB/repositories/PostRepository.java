package com.pbcompass.Projeto_WebServices_com_MongoDB.repositories;

import com.pbcompass.Projeto_WebServices_com_MongoDB.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
