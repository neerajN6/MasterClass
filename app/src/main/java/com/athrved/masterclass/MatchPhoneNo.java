package com.athrved.masterclass;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MatchPhoneNo extends AppCompatActivity {
    public long Phone, PHONENO;
    String phone1;
    DatabaseReference mDatabaseRef;
    int childCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_phone_no);
        String _getUserEnteredNumber = getIntent().getStringExtra("PHONENO");
        PHONENO = Long.parseLong(_getUserEnteredNumber);
        phone1 = _getUserEnteredNumber;
        Log.d(TAG, "PhoneNoInMatch1 : " + PHONENO);
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


                    if (PHONENO == PhoneNo) {
                        Log.d("Email", Email);
                        Log.d("EmailLogin", String.valueOf(PHONENO));
                        Intent intent = new Intent(MatchPhoneNo.this, MainActivity.class);
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
        Intent intent2 = new Intent(MatchPhoneNo.this, Dashboard.class);
        intent2.putExtra("NO", phone1);
        Log.d(TAG, "PhoneNoInMatch2 : " + phone1);
        startActivity(intent2);
        finish();
    }
}