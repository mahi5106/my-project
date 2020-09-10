package com.example.recyclerwithmvvm.Adapter;

import android.content.ClipData;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerwithmvvm.Model.Hero;
import com.example.recyclerwithmvvm.R;

import java.util.List;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.HeroViewHolder> {

    Context context;
    List<Hero>heroList;

    public HeroesAdapter(Context context, List<Hero> heroList) {
        this.context = context;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_layout,parent,false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
    Hero hero = heroList.get(position);
        Glide.with(context)
                .load(hero.getImageurl())
                .into(holder.imageView);

        holder.textView.setText(hero.getName());
        holder.textView2.setText(hero.getBio());

    }



    @Override
    public int getItemCount() {
        return heroList.size();

    }

    public void removeItem(int position){
        heroList.remove(position);
        notifyItemRemoved(position);
    }




    class HeroViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView,textView2;

        public HeroViewHolder(View itemView){
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);

        }
    }
}
