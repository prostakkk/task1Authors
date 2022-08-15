package com.example.authorAPI.entity;


import javax.persistence.*;
import java.util.List;


@Entity
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String authorCode;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<BooksEntity> books;
    // Error with List

    public AuthorEntity() {


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorCode() {
        return authorCode;
    }

    public void setAuthorCode(String authorCode) {
        this.authorCode = authorCode;
    }
}
