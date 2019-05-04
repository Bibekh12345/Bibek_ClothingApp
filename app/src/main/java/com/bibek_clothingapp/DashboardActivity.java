package com.bibek_clothingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

import adapter.ItemAdapter;
import model.Item;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.recyclerView);

        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("White",500,R.drawable.ic_launcher_foreground,"White Shirt."));


        ItemAdapter itemAdapter = new ItemAdapter(DashboardActivity.this, itemList);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }

}
