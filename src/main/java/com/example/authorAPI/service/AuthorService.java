package com.example.authorAPI.service;

import com.example.authorAPI.entity.AuthorEntity;
import com.example.authorAPI.exception.AuthorAlreadyExistException;
import com.example.authorAPI.exception.AuthorNotFoundException;
import com.example.authorAPI.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorEntity addAuthor(AuthorEntity author) throws AuthorAlreadyExistException {
        if(authorRepository.findByName(author.getName()) != null) {
            throw new AuthorAlreadyExistException("Author with same name already exist");
        }
       return  authorRepository.save(author);
    }

    public AuthorEntity getAuthor(Long id) throws AuthorNotFoundException {
        AuthorEntity author = authorRepository.findById(id).get();
        if(author == null){
            throw new AuthorNotFoundException("Author not found");
        }
        return author;
    }

    public Long deleteAuthor(Long id) {
       authorRepository.deleteById(id);
       return id;
    }


}
