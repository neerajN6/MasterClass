package com.athrved.masterclass;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FacebookProfile extends AppCompatActivity {

    private TextView mail;
    private EditText name, phone, bio;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = mAuth.getCurrentUser();
    Button logOutBtn, saveBtn;
    private String Name;
    private String Email;
    private String Bio;
    private long Phone;
    int childCount;
    private DatabaseReference mDatabaseRef;
    private ProgressBar progressBarOfFacebookProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_profile);

        logOutBtn = findViewById(R.id.logOutBtnInFacebookProfile);
        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);

        phone = findViewById(R.id.phone);
        bio = findViewById(R.id.bio);
        saveBtn = findViewById(R.id.SaveBtn);
        progressBarOfFacebookProfile = findViewById(R.id.progressbarofFacebookProfile);

        bio.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                // If line account is higher than MAX_LINES, set text to lastText
                // and notify user (by Toast)
                if (bio.length() > 99) {
                    Toast.makeText(getApplicationContext(), "Maximum characters exceeded", Toast.LENGTH_SHORT).show();
                }
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validatePhoneNo() | !validateName()) {
                    return;
                } else {
                    progressBarOfFacebookProfile.setVisibility(View.VISIBLE);

                    Name = name.getText().toString();
                    Email = mail.getText().toString();
                    Phone = new Long(phone.getText().toString()).longValue();
                    Bio = bio.getText().toString();

                    getDataToFirebase();

                    Database db = new Database();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                    finish();
                }

            }
        });

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



    private Boolean validatePhoneNo() {
        String val = phone.getText().toString();

        if (val.isEmpty()) {
            phone.setError("Field cannnot be empty");
            return false;
        } else {
            phone.setError(null);
            return true;
        }

    }

    private Boolean validateName() {
        String val = name.getText().toString();

        if (val.isEmpty()) {
            name.setError("Field cannnot be empty");
            return false;
        } else {
            name.setError(null);
            return true;
        }

    }

    private void getDataToFirebase(){

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Users");
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                childCount = (int) dataSnapshot.getChildrenCount();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String free = ds.getKey();
                    Log.d(TAG, free);

                    ProfileHelper profileHelper = new ProfileHelper(Name, Email, Phone, Bio);
                    mDatabaseRef.child(String.valueOf(childCount + 1)).setValue(profileHelper);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
            }
        };
        mDatabaseRef.addListenerForSingleValueEvent(valueEventListener);
    }

}
