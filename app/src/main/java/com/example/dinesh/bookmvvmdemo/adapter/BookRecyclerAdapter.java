package com.example.dinesh.bookmvvmdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dinesh.bookmvvmdemo.R;
import com.example.dinesh.bookmvvmdemo.model.Book;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// Created by Dinesh Kumar on 4/29/2019
public class BookRecyclerAdapter extends RecyclerView.Adapter<BookRecyclerAdapter.MyViewHolder> {
    private ArrayList<Book> _bookList;
    private Context _context;

    public BookRecyclerAdapter(Context context, ArrayList<Book> bookList) {
        this._context = context;
        this._bookList = bookList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(_context).inflate(R.layout.layout_book_recycler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Book book = _bookList.get(position);

        holder.txtBookName.setText(book.getName());
        holder.txtBookAuthor.setText(book.getAuthorName());
        holder.txtBookPrice.setText("" + book.getPrice());
    }

    @Override
    public int getItemCount() {
        return _bookList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtBookName;
        TextView txtBookAuthor;
        TextView txtBookPrice;

        MyViewHolder(View view) {
            super(view);

            txtBookName = view.findViewById(R.id.txtBookName);
            txtBookAuthor = view.findViewById(R.id.txtBookAuthorName);
            txtBookPrice = view.findViewById(R.id.txtBookPrice);
        }
    }
}
