package com.vgpmdb.moviecatalogservice.entity;

import lombok.Data;

@Data
public class Catalog {

    private int id;
    private String name;
    private String desc;
    private String rating;

    public Catalog(int id, String name, String desc, String rating) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }
}
