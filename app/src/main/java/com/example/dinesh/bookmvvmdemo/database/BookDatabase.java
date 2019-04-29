package com.example.dinesh.bookmvvmdemo.database;

import android.content.Context;
import android.os.AsyncTask;

import com.example.dinesh.bookmvvmdemo.model.Book;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

// Created by Dinesh Kumar on 4/29/2019
@Database(entities = {Book.class}, version = 1)
public abstract class BookDatabase extends RoomDatabase {
    private static BookDatabase _instance;

    public abstract BookDao getBookDao();

    public static BookDatabase getInstance(Context context) {
        if (_instance == null) {
            _instance = Room.databaseBuilder(context, BookDatabase.class, "BookStoreDatabase")
                    .fallbackToDestructiveMigration()
                    .addCallback(addDataOnCreateCallback)
                    .build();

        }
        return _instance;
    }

    private static Callback addDataOnCreateCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new AddDataAsync(_instance).execute();
        }
    };


    private static class AddDataAsync extends AsyncTask<Void,Void,Void>{
        BookDao bookDao;
        AddDataAsync(BookDatabase database){
            this.bookDao = database.getBookDao();
        }

        @Override
        protected Void doInBackground(Void[] objects) {
            bookDao.insert(new Book("Principle of OOPs","Tom Berlin",860));
            bookDao.insert(new Book("The Head First","Kathy Siria",675));
            bookDao.insert(new Book("Java Complete Reference","O'Rielly",440));
            return null;
        }
    }

}
