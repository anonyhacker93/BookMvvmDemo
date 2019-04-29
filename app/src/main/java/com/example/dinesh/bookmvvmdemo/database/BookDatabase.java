package com.example.dinesh.bookmvvmdemo.database;

import android.content.Context;

import com.example.dinesh.bookmvvmdemo.model.Book;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// Created by Dinesh Kumar on 4/29/2019
@Database(entities = {Book.class}, version = 1)
public abstract class BookDatabase extends RoomDatabase {
    private static BookDatabase _instance;

    public abstract BookDao getBookDao();

    public static BookDatabase getInstance(Context context) {
        if (_instance == null) {
            _instance = Room.databaseBuilder(context, BookDatabase.class, "BookStoreDatabase")
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return _instance;
    }



}
