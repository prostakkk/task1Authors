package com.example.authorAPI.model;


import com.example.authorAPI.entity.BooksEntity;

public class Books {
    private Long id;
    private String title;


    public static Books toModel(BooksEntity entity){
        Books model = new Books();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        return model;
    }


    public Books() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
