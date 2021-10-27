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

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {

    private TextView mail;
    private EditText name, phone, bio;
    Button logOut, saveBtn;
    public String Name;
    public String Email, emailTv;
    public String Bio;
    public long Phone;
    int childCount;
    private DatabaseReference mDatabaseRef;
    private ProgressBar progressBarOfProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        logOut = findViewById(R.id.logOutBtn);
        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        phone = findViewById(R.id.phone);
        bio = findViewById(R.id.bio);
        saveBtn = findViewById(R.id.SaveBtn);
        progressBarOfProfile = findViewById(R.id.progressbarofProfile);

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
                    progressBarOfProfile.setVisibility(View.VISIBLE);
                    emailTv = mail.getText().toString();

                    Name = name.getText().toString();
                    Email = mail.getText().toString();
                    Phone = new Long(phone.getText().toString()).longValue();
                    Bio = bio.getText().toString();

                    getDataToFirebase();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (signInAccount != null) {
            name.setText(signInAccount.getDisplayName());
            mail.setText(signInAccount.getEmail());
        }


        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
            }
        });


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

    private void getDataToFirebase() {
        Log.d(TAG, "Email1 : " + emailTv);

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
