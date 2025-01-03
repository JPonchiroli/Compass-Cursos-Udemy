package org.pbcompass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.pbcompass.data.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}