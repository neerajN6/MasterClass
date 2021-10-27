package com.athrved.masterclass;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MatchFacebookEmail extends AppCompatActivity {
    String EMAIL;
    DatabaseReference mDatabaseRef;
    int childCount;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = mAuth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_facebook_email);
        if (user != null) {
            EMAIL = user.getEmail();
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
                        Intent intent = new Intent(MatchFacebookEmail.this, MainActivity.class);
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
        Intent intent2 = new Intent(MatchFacebookEmail.this, FacebookProfile.class);
        startActivity(intent2);
        finish();
    }
}
