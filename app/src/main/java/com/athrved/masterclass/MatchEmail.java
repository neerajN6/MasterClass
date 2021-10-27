package com.athrved.masterclass;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MatchEmail extends AppCompatActivity {
    DatabaseReference mDatabaseRef;
    int childCount;
    String email, EMAIL;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_email);
        progressBar = findViewById(R.id.progressBarInMatchEmail);

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (signInAccount != null) {
            EMAIL = signInAccount.getEmail();
        }

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Users");

        ValueEventListener valueEventListener1 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d(TAG, "Number of children: " + dataSnapshot.getChildrenCount());
                childCount = (int) dataSnapshot.getChildrenCount();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String free = ds.getKey();
                    Log.d(TAG, free);


                    forLoop(); //call function!

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
            }
        };
        mDatabaseRef.addValueEventListener(valueEventListener1);


    }

    private void forLoop() {
        for (int i = 1; i <= childCount; i++) {

            DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
            DatabaseReference projectDetailsRef = rootRef.child("Users").child(String.valueOf(i));
            ValueEventListener valueEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String Name = dataSnapshot.child("uName").getValue(String.class);
                    String Email = dataSnapshot.child("uEmail").getValue(String.class);
                    Long PhoneNo = dataSnapshot.child("uPhone").getValue(Long.class);
                    String Bio = dataSnapshot.child("uBio").getValue(String.class);


                    if (EMAIL.equals(Email)) {
                        Log.d("Email", Email);
                        Log.d("EmailLogin", EMAIL);
                        Intent intent = new Intent(MatchEmail.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.d("TAG", databaseError.getMessage()); //Don't ignore potential errors!
                }
            };
            projectDetailsRef.addListenerForSingleValueEvent(valueEventListener);
        }
        Intent intent2 = new Intent(MatchEmail.this, Profile.class);
        startActivity(intent2);
        finish();
    }

}