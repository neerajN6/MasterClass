package com.athrved.masterclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.athrved.masterclass.uiux.Testing;

public class AdminAccessPage extends AppCompatActivity {
    Button addMentor, addVideos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_access_page);

        addMentor = findViewById(R.id.addMentor);
        addVideos = findViewById(R.id.addVideos);

        addMentor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminAccessPage.this,AddMentors.class);
                startActivity(intent);
            }
        });

        addVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminAccessPage.this, Testing.class);
                startActivity(intent);
            }
        });
    }
}