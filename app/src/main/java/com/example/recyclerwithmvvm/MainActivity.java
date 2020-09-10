package com.example.recyclerwithmvvm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.recyclerwithmvvm.Adapter.HeroesAdapter;
import com.example.recyclerwithmvvm.Model.Hero;
import com.example.recyclerwithmvvm.ViewModel.HeroesViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
     RecyclerView recyclerView;
     HeroesAdapter heroesAdapter;
    HeroesViewModel model;

   public static ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading...");


        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

         model = ViewModelProviders.of(this).get(HeroesViewModel.class);

        model.getHeroes().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroList) {
                heroesAdapter = new HeroesAdapter(MainActivity.this, heroList);
                recyclerView.setAdapter(heroesAdapter);
            }
        });


    }


}