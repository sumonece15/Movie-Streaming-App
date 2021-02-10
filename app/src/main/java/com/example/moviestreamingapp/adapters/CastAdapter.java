package com.example.moviestreamingapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviestreamingapp.R;
import com.example.moviestreamingapp.models.Cast;
import com.example.moviestreamingapp.ui.MovieDetailActivity;

import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {

    Context mContext;
    List<Cast> mData;

    public CastAdapter(Context mContext, List<Cast> mData, MovieDetailActivity movieDetailActivity) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_cast, parent, false);
        return new CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder holder, int position) {

        Glide.with(mContext).load(mData.get(position).getImg_link()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class CastViewHolder extends RecyclerView.ViewHolder {

        ImageView img;

        public CastViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img_cast);
        }
    }
}
