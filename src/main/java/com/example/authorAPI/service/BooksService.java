package com.example.authorAPI.service;

import com.example.authorAPI.entity.AuthorEntity;
import com.example.authorAPI.entity.BooksEntity;
import com.example.authorAPI.model.Books;
import com.example.authorAPI.repository.AuthorRepository;
import com.example.authorAPI.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService {
    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public Books addBook(BooksEntity books, Long authorId){
        AuthorEntity author = authorRepository.findById(authorId).get();
        books.setAuthor(author);
        return Books.toModel(booksRepository.save(books));
    }

    public List<BooksEntity> getBooks(){
        List<BooksEntity> books = new ArrayList<BooksEntity>();
        booksRepository.findAll().forEach(book -> books.add(book));
        return books;
    }



    public BooksEntity updateBook(BooksEntity books){
        BooksEntity existingBook = booksRepository.findById(books.getId()).orElse(null);
        existingBook.setTitle(books.getTitle());
        return  booksRepository.save(existingBook);
    }

}
