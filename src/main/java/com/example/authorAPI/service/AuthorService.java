package com.example.authorAPI.service;

import com.example.authorAPI.entity.AuthorEntity;
import com.example.authorAPI.exception.AuthorAlreadyExistException;
import com.example.authorAPI.exception.AuthorNotFoundException;
import com.example.authorAPI.model.Author;
import com.example.authorAPI.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

//    public Author getAuthor(Long id) throws AuthorNotFoundException {
//        AuthorEntity author = authorRepository.findById(id).get();
//        if(author == null){
//            throw new AuthorNotFoundException("Author not found");
//        }  // No value present
//        return Author.toModel(author);
//    }

    public AuthorEntity getAuthor(Long id) throws AuthorNotFoundException {
        AuthorEntity author = authorRepository.findById(id).get();
        if(author == null){
            throw new AuthorNotFoundException("Author not found");
        }  // No value present
        return author;
    }

    public List<AuthorEntity> getAuthors(){
        List<AuthorEntity> authors = new ArrayList<AuthorEntity>();
        authorRepository.findAll().forEach(author -> authors.add(author));
        return authors;
    }



    public Long deleteAuthor(Long id) {
       authorRepository.deleteById(id);
       return id;
    }


    public void deleteAuthors(AuthorEntity author) throws AuthorNotFoundException {
        if(authorRepository.findAllById(author.getId()) == null) {
            throw new AuthorNotFoundException("There are no authors.");
        }
        authorRepository.deleteAll();
    }

    public AuthorEntity updateAuthor(AuthorEntity author){
        AuthorEntity existingAuthor = authorRepository.findById(author.getId()).orElse(null);
        existingAuthor.setName(author.getName());
        existingAuthor.setAuthorCode(author.getAuthorCode());
        return  authorRepository.save(existingAuthor);
    }


}
