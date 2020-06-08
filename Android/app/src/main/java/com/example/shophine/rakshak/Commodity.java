package com.example.shophine.rakshak;

/**
 * Created by shophine on 6/1/18.
 */

public class Commodity {
    private int id;
    private String name;

    public Commodity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Commodity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
