package com.jek.recipetaste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String title = "Mode List";
    private RecyclerView rvResep;
    private ArrayList<Resep> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView btn_profilee = findViewById(R.id.btn_profile);
        btn_profilee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ProfileActivity.class));
            }
        });
        rvResep = findViewById(R.id.menu_name);
        rvResep.setHasFixedSize(true);

        list.addAll(ResepData.getListData());
        showRecyclerList();
        btn_profilee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(i);
            }
        });
    }

    private void showRecyclerList() {
        rvResep.setLayoutManager(new LinearLayoutManager(this));
        ListResepAdapter listAdapter = new ListResepAdapter(list);
        rvResep.setAdapter((RecyclerView.Adapter) listAdapter);


    }
}
