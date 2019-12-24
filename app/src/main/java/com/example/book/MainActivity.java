package com.example.book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.book.model.book;
import com.example.book.recyderview.BookAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     private RecyclerView rvBooks;
     private BookAdapter bookAdapter;
     private List<book> mdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initmdatabooks();
        setupBookAdapter();


    }private void setupBookAdapter(){
        bookAdapter = new BookAdapter(mdata);
        rvBooks.setAdapter(bookAdapter);
    }
    private void initmdatabooks(){
        mdata = new ArrayList<>();
        mdata.add(new book(R.drawable.book_1));
        mdata.add(new book(R.drawable.book_2));
        mdata.add(new book(R.drawable.book_3));
        mdata.add(new book(R.drawable.book_4));

    }

    private void initViews() {
        rvBooks = findViewById(R.id.rv_book);
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
        rvBooks.setHasFixedSize(true);
    }
}
