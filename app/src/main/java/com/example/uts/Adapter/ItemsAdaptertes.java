package com.example.uts.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.uts.Domain.ItemsDomain;
import com.example.uts.R;
import com.example.uts.activites.DetailActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class ItemsAdaptertes extends RecyclerView.Adapter<ItemsAdaptertes.ViewHolder>{


    ArrayList<ItemsDomain>items;
    DecimalFormat formatter;
    Context context;

    public ItemsAdaptertes(ArrayList<ItemsDomain> items) {
        this.items = items;
        formatter=new DecimalFormat("###,###,###,##");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewholder,parent,false);
        context= parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.themTxt.setText(items.get(position).getThem());
        holder.dateTxt.setText(items.get(position).getDate());
        holder.tittleTxt.setText((items.get(position).getTittle()));

        int drawableResourceId=holder.itemView.getResources().getIdentifier(items.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.itemView.setOnClickListener(view -> {
            Intent intent=new Intent(context, DetailActivity.class);
            intent.putExtra("object",items.get(position));
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    TextView themTxt,dateTxt, tittleTxt;
    ImageView pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            themTxt=itemView.findViewById(R.id.themTxt);
            dateTxt=itemView.findViewById(R.id.dateTxt);
            tittleTxt=itemView.findViewById(R.id.tittleTxt);
            pic=itemView.findViewById(R.id.pic);
        }
    }
}
