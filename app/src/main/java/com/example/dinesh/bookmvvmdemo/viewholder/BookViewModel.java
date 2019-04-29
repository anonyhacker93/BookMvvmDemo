package com.example.dinesh.bookmvvmdemo.viewholder;

import android.app.Application;

import com.example.dinesh.bookmvvmdemo.model.Book;
import com.example.dinesh.bookmvvmdemo.repository.BookRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

// Created by Dinesh Kumar on 4/29/2019
public class BookViewModel extends AndroidViewModel {
   private BookRepository bookRepository;
    public BookViewModel(@NonNull Application application) {
        super(application);
        bookRepository = BookRepository.getInstance(application);
    }

    public void insert(Book book){
        bookRepository.insert(book);
    }

    public void delete(Book book){
        bookRepository.delete(book);
    }

    public LiveData<List<Book>> getBooksData(){
        return bookRepository.getBooksData();
    }

}
