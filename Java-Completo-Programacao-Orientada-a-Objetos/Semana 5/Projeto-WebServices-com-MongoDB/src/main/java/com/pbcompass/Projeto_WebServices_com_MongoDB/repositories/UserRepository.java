package com.pbcompass.Projeto_WebServices_com_MongoDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pbcompass.Projeto_WebServices_com_MongoDB.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
