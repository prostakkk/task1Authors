package com.example.authorAPI.service;

import com.example.authorAPI.entity.AuthorEntity;
import com.example.authorAPI.entity.BooksEntity;
import com.example.authorAPI.repository.AuthorRepository;
import com.example.authorAPI.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public BooksEntity addBook(BooksEntity books, Long authorId){
        AuthorEntity author = authorRepository.findById(authorId).get();
        books.setAuthor(author);
        return booksRepository.save(books);
    }
    public BooksEntity updateBook(Long id){
    BooksEntity books = booksRepository.findById(id).get();
    books.setTitle(books.getTitle());
    return booksRepository.save(books);
    }
}
