package com.vgpmdb.moviecatalogservice.entity;

import lombok.Data;

@Data
public class Movie {

    private int id;
    private String name;

    public Movie() {
    }

    public Movie(int id, String name) {
        this.id = id;
        this.name = name;
    }


}
