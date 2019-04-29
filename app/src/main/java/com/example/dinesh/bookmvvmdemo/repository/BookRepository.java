package com.example.dinesh.bookmvvmdemo.repository;

import android.content.Context;

import com.example.dinesh.bookmvvmdemo.database.BookDao;
import com.example.dinesh.bookmvvmdemo.database.BookDatabase;
import com.example.dinesh.bookmvvmdemo.model.Book;

import java.util.List;

import androidx.lifecycle.LiveData;

// Created by Dinesh Kumar on 4/29/2019
public class BookRepository {
    private static BookRepository _instance;
    private static BookDatabase bookDatabase;

    public static BookRepository getInstance(Context context) {
        if (_instance == null) {
            _instance = new BookRepository();
            bookDatabase = BookDatabase.getInstance(context);
        }
        return _instance;
    }

    public static BookDao getBookDao() {
        return bookDatabase.getBookDao();
    }

    public LiveData<List<Book>> getBooksData() {
        return getBookDao().getBooksData();
    }

    public void insert(Book book){
        getBookDao().insert(book);
    }

    public void delete(Book book){
        getBookDao().deleteById(book);
    }
}
