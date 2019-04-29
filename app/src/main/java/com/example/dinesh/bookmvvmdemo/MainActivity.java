package com.example.dinesh.bookmvvmdemo;

import android.os.Bundle;

import com.example.dinesh.bookmvvmdemo.adapter.BookRecyclerAdapter;
import com.example.dinesh.bookmvvmdemo.model.Book;
import com.example.dinesh.bookmvvmdemo.viewholder.BookViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private BookViewModel _bookViewModel;
    private RecyclerView _bookRecyclerView;
    private BookRecyclerAdapter _adapter;
    private ArrayList<Book> _bookList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        initViews();

        _bookViewModel = ViewModelProviders.of(this).get(BookViewModel.class);
        _bookViewModel.getBooksData().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> books) {
              //  _bookList.clear();
                _bookList.addAll(books);
                _adapter.notifyDataSetChanged();
            }
        });
    }

    private void initViews() {
        _bookRecyclerView = findViewById(R.id.recyclerView);
        setRecyclerView();
    }

    private void setRecyclerView() {
        _bookList = new ArrayList<>();
        _adapter = new BookRecyclerAdapter(this,_bookList);
        _bookRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        _bookRecyclerView.setAdapter(_adapter);
    }
}
