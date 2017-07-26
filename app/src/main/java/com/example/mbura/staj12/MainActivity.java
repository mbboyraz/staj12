package com.example.mbura.staj12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {

        RecyclerViewAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // data to populate the RecyclerView with
            ArrayList<String> animalNames = new ArrayList<>();
            animalNames.add("Horse");
            animalNames.add("Cow");
            animalNames.add("Camel");
            animalNames.add("Sheep");
            animalNames.add("Goat");

            // set up the RecyclerView
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvAnimals);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new RecyclerViewAdapter(this, animalNames);
            adapter.setClickListener(this);
            recyclerView.setAdapter(adapter);
        }

        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        }
    }

