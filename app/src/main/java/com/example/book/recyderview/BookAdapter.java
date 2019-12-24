package com.example.book.recyderview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.book.R;
import com.example.book.model.book;

import java.util.List;
import java.util.concurrent.TimeoutException;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.bookviewholder> {

    List<book> mdata;

    public BookAdapter(List<book> mdata) {
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public bookviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_book, parent,false);
                return  new bookviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull bookviewholder holder, int position) {

        Glide.with(holder.itemView.getContext())
        .load(mdata.get(position).getDrawableResource())
                .transforms(new CenterCrop(), new RoundedCorners(16))
                .into(holder.imgBook);
        holder.ratingBar.setRating((float)4.5);

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class bookviewholder extends RecyclerView.ViewHolder{


        ImageView imgBook, imgFav;
        TextView title, author , pages, rate;
        RatingBar ratingBar;
        public bookviewholder(@NonNull View itemView) {
            super(itemView);
             imgBook = itemView.findViewById(R.id.book_1);
             title = itemView.findViewById(R.id.text_1);
             author = itemView.findViewById(R.id.item_book_author);
             pages = itemView.findViewById(R.id.item_book_pages);
             rate = itemView.findViewById(R.id.item_book_score);
             ratingBar = itemView.findViewById(R.id.rating_1);
        }
    }



}
