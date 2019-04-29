package com.example.dinesh.bookmvvmdemo;

import android.os.Bundle;

import com.example.dinesh.bookmvvmdemo.model.Book;
import com.example.dinesh.bookmvvmdemo.viewholder.BookViewModel;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {
    private BookViewModel _bookViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        _bookViewModel = ViewModelProviders.of(this).get(BookViewModel.class);
        _bookViewModel.getBooksData().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> books) {

            }
        });
    }
}
