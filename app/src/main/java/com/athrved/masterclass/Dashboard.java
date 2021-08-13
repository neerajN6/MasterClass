package com.athrved.masterclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {

    Button logOutBtnInDashboard;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        logOutBtnInDashboard = findViewById(R.id.logOutBtnInDashboard);
        mAuth = FirebaseAuth.getInstance();

        logOutBtnInDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                LoginManager.getInstance().logOut();
                openLogin();
            }
        });
    }

    private void openLogin() {
        startActivity(new Intent(this, SignUp.class));
        finish();
    }
}