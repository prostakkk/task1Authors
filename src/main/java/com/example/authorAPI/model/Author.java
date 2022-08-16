package com.example.authorAPI.model;

import com.example.authorAPI.entity.AuthorEntity;

public class Author {
    private Long id;
    private String name;

    public static Author toModel(AuthorEntity entity){
        Author model = new Author();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }



    public Author() {
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
}
