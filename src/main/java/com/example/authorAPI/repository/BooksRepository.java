package com.example.authorAPI.repository;

import com.example.authorAPI.entity.AuthorEntity;
import com.example.authorAPI.entity.BooksEntity;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<BooksEntity, Long> {

}
