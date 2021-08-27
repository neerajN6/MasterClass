package com.athrved.masterclass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TermsAndCondition extends AppCompatActivity {

    ImageButton backButtonInTermsAndConditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_condition);

        backButtonInTermsAndConditions = findViewById(R.id.backBtnInTermsAndConditions);
        backButtonInTermsAndConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TermsAndCondition.this, SignUp.class);
                startActivity(intent);
                finish();
            }
        });
    }
}