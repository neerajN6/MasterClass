package com.athrved.masterclass;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateProfile extends AppCompatActivity {

    private TextView mail;
    private EditText name, phone, bio;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = mAuth.getCurrentUser();
    Button logOutBtn, updateBtn;
    private String Name, phoneNo2 = "";
    private String Email, email1, Email2 = "", Email3 = "", emailTv;
    private String Bio;
    private long Ph;
    DatabaseReference mDatabaseRef;
    int childCount, i;
    String PHONENO, MAIL, Phone, getnumber = "", parent;
    private ProgressBar progressBarOfUpdateProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        mail = findViewById(R.id.mail);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        bio = findViewById(R.id.bio);
        logOutBtn = findViewById(R.id.logOutBtn);
        updateBtn = findViewById(R.id.updateBtn);
        progressBarOfUpdateProfile = findViewById(R.id.progressbarofUpdateProfile);

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

        if (user != null) {
            email1 = user.getEmail();
            Log.d(TAG, "email1" + email1);
        }

        if (user != null) {
            name.setText(user.getDisplayName());
            mail.setText(user.getEmail());
            phone.setText(user.getPhoneNumber());
            PHONENO = user.getPhoneNumber();
            Log.d(TAG, "PhNo" + PHONENO);
            MAIL = user.getEmail();
        }

        if (PHONENO != null) {
            if (PHONENO.length() > 10) {
                int startidx = PHONENO.length() - 10;
                getnumber = PHONENO.substring(startidx, PHONENO.length());
                phone.setText(getnumber);
                Log.d(TAG, "GetNo" + getnumber);
            } else {
                phone.setText(Phone);
            }
        }


        name.setText(Name);
        bio.setText(Bio);
        phone.setText(Phone);
        mail.setText(Email);


        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                LoginManager.getInstance().logOut();
                openLogin();
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validatePhoneNo() | !validateName()) {
                    return;
                } else {
                    progressBarOfUpdateProfile.setVisibility(View.VISIBLE);
                    emailTv = mail.getText().toString();

                    Name = name.getText().toString();
                    Email = mail.getText().toString();
                    Ph = new Long(phone.getText().toString()).longValue();
                    Bio = bio.getText().toString();

                    getDataToFirebase();

                    Intent intent = new Intent(getApplicationContext(), UpdateProfile.class);
                    startActivity(intent);
                    finish();

                    Toast.makeText(getApplicationContext(), "Update Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });

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

        if (email1 == null) {
            email1 = "Empty String";
            Log.d("EmailError : ", email1);
        }


    }

    private void forLoop() {
        for (i = 1; i <= childCount; i++) {

            DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
            DatabaseReference projectDetailsRef = rootRef.child("Users").child(String.valueOf(i));
            ValueEventListener valueEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String Name = dataSnapshot.child("uName").getValue(String.class);
                    Email2 = dataSnapshot.child("uEmail").getValue(String.class);
                    Long PhoneNo = dataSnapshot.child("uPhone").getValue(Long.class);
                    String Bio = dataSnapshot.child("uBio").getValue(String.class);
                    phoneNo2 = "";
                    phoneNo2 = String.valueOf(PhoneNo);


                    if (email1.equalsIgnoreCase(Email2)) {
                        parent = dataSnapshot.getKey();
                        mail.setText(email1);
                        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                        DatabaseReference projectDetailsRef = rootRef.child("Users").child(parent);
                        ValueEventListener valueEventListener = new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                String Name = dataSnapshot.child("uName").getValue(String.class);
                                Email3 = dataSnapshot.child("uEmail").getValue(String.class);
                                Long PhoneNo = dataSnapshot.child("uPhone").getValue(Long.class);
                                String phoneNo1 = String.valueOf(PhoneNo);
                                String Bio = dataSnapshot.child("uBio").getValue(String.class);


                                if (email1.equals(Email3)) {
                                    String parent = dataSnapshot.getKey();
                                    mail.setText(email1);
                                    name.setText(Name);
                                    phone.setText(phoneNo1);
                                    bio.setText(Bio);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                Log.d("TAG", databaseError.getMessage()); //Don't ignore potential errors!
                            }
                        };
                        projectDetailsRef.addListenerForSingleValueEvent(valueEventListener);
                    } else if (getnumber.equals(phoneNo2)) {
                        Log.d(TAG, "GETNUMBER : " + getnumber);
                        Log.d(TAG, "PHONENO2 : " + phoneNo2);
                        parent = dataSnapshot.getKey();
                        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                        DatabaseReference projectDetailsRef = rootRef.child("Users").child(parent);
                        Log.d(TAG, "Parent : " + parent);
                        ValueEventListener valueEventListener = new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                String Name2 = dataSnapshot.child("uName").getValue(String.class);
                                String Email5 = dataSnapshot.child("uEmail").getValue(String.class);
                                Long PhoneNo = dataSnapshot.child("uPhone").getValue(Long.class);
                                String phoneNo3 = String.valueOf(PhoneNo);
                                String Bio4 = dataSnapshot.child("uBio").getValue(String.class);


                                mail.setText(Email5);
                                name.setText(Name2);
                                phone.setText(phoneNo3);
                                bio.setText(Bio4);

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                Log.d("TAG", databaseError.getMessage()); //Don't ignore potential errors!
                            }
                        };
                        projectDetailsRef.addListenerForSingleValueEvent(valueEventListener);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.d("TAG", databaseError.getMessage()); //Don't ignore potential errors!
                }
            };
            projectDetailsRef.addListenerForSingleValueEvent(valueEventListener);
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

                    ProfileHelper profileHelper = new ProfileHelper(Name, Email, Ph, Bio);
                    mDatabaseRef.child(String.valueOf(parent)).setValue(profileHelper);
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