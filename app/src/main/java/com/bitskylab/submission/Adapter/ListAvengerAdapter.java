package com.bitskylab.submission.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bitskylab.submission.Data.Avenger;
import com.bitskylab.submission.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListAvengerAdapter extends RecyclerView.Adapter<ListAvengerAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Avenger> listAvenger;

    private ArrayList<Avenger> getListAvenger() {
        return listAvenger;
    }

    public void setListAvenger(ArrayList<Avenger> listAvenger) {
        this.listAvenger = listAvenger;
    }

    public ListAvengerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ListAvengerAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_avenger, viewGroup, false);
        return new ListAvengerAdapter.CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAvengerAdapter.CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvName.setText(getListAvenger().get(position).getName());
        categoryViewHolder.tvRemarks.setText(getListAvenger().get(position).getRemarks());

        Glide.with(context)
                .load(getListAvenger().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListAvenger().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
