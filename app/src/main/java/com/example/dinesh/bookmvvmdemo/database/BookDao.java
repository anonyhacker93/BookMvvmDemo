package com.example.dinesh.bookmvvmdemo.database;

import com.example.dinesh.bookmvvmdemo.model.Book;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

// Created by Dinesh Kumar on 4/29/2019
@Dao
public interface BookDao {

    @Insert
    void insert(Book book);

    @Query("delete from book_store where id = :ids")
    void deleteById(int ids);

    @Delete
    void deleteById(Book book);

    @Query("select * from book_store")
    LiveData<List<Book>> getBooksData();

    @Update
    void update(Book book);

}
