package com.athrved.masterclass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FacebookProfile extends AppCompatActivity {

    private TextView name, mail;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = mAuth.getCurrentUser();
    Button logOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_profile);

        logOutBtn = findViewById(R.id.logOutBtnInFacebookProfile);
        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);

        if (user != null) {
            name.setText(user.getDisplayName());
            mail.setText(user.getEmail());
        }

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                LoginManager.getInstance().logOut();
                openLogin();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (user == null) {
            openLogin();
        }
    }

    private void openLogin() {
        startActivity(new Intent(this, SignUp.class));
        finish();
    }


}
