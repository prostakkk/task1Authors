package com.example.authorAPI.repository;

import com.example.authorAPI.entity.AuthorEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
    AuthorEntity findByName(String name);

}
