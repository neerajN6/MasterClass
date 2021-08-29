package com.athrved.masterclass;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView dataList;
    List<String> titles;
    List<Integer> images;
    ImgAdapter imgAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataList = findViewById(R.id.dataList);


       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("Artificial\nIntelligence");
        titles.add("Web\nDevelopment");
        titles.add("App\nDevelopment");
        titles.add("Machine\nDesign");
        titles.add("UI/UX\nDesign");
        titles.add("Internet of\nThings");

        images.add(R.drawable.ai_logo);
        images.add(R.drawable.web_logo);
        images.add(R.drawable.appdev_logo);
        images.add(R.drawable.mach_logo);
        images.add(R.drawable.uiux_logo);
        images.add(R.drawable.iot_logo);


        imgAdapter = new ImgAdapter(this,titles,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(imgAdapter);





    }
}