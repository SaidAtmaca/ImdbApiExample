package com.said.imdbapiexample.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.said.imdbapiexample.Api.ItemsInfo;
import com.said.imdbapiexample.Api.MoviesInfo;
import com.said.imdbapiexample.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RowHolder> {


    public RecyclerViewAdapter(ItemsInfo itemsInfos) {
        this.itemsInfos = itemsInfos;
    }

    private ItemsInfo itemsInfos;



    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.recycle_row,parent,false);

        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {

        holder.movieTitle.setText(itemsInfos.getItems().get(position).title);
        holder.movieYear.setText(itemsInfos.getItems().get(position).year);
        holder.movieRank.setText(itemsInfos.getItems().get(position).rank);
        Picasso.get().load(itemsInfos.getItems().get(position).image).into(holder.movieImage); //Picaaso buraya erklenecek

    }

    @Override
    public int getItemCount() {
        return itemsInfos.getItems().size();
    }

    public class RowHolder extends RecyclerView.ViewHolder{


        TextView movieRank, movieTitle, movieYear;
        ImageView movieImage;

        public RowHolder(@NonNull View itemView) {
            super(itemView);

            movieRank=itemView.findViewById(R.id.movieRank);
            movieTitle=itemView.findViewById(R.id.movieTitle);
            movieYear=itemView.findViewById(R.id.movieYear);
            movieImage=itemView.findViewById(R.id.movieImage);
        }
    }
}
