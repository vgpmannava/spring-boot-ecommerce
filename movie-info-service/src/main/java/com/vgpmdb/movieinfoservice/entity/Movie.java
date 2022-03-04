package com.vgpmdb.movieinfoservice.entity;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class Movie {

    private int id;
    private String name;

    public Movie(int id, String name) {
        this.id = id;
        this.name = name;
    }


}
