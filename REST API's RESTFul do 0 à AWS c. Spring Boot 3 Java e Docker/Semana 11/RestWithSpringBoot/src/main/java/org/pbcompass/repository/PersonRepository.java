package org.pbcompass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.pbcompass.data.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}