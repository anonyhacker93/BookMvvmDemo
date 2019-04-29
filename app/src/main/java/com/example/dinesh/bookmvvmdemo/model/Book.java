package com.example.dinesh.bookmvvmdemo.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Created by Dinesh Kumar on 4/29/2019
@Entity(tableName = "book_store")
public class Book {
    @PrimaryKey
    private int id;
    private String name;
    private String authorName;
    private int price;


    public Book(String name, String authorName, int price) {
        this.name = name;
        this.authorName = authorName;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getPrice() {
        return price;
    }
}

