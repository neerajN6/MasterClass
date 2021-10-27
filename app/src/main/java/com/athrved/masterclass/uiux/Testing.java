package com.athrved.masterclass.uiux;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.athrved.masterclass.R;
import com.athrved.masterclass.Upload;
import com.athrved.masterclass.UploadVideo;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Testing extends AppCompatActivity {

    private Button mAddVideo;
    private EditText mEditTextVideoTitle, mEditTextTopicId, mEditTextVideoId;
    private DatabaseReference mDatabaseRef;
    private FirebaseDatabase mDatabase;
    private ProgressBar mProgressBar;
    String userId, TopicIdString;
    int CourseId, PaidId, TopicId;
    int childCount;
    Spinner spinner3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);


        mAddVideo = findViewById(R.id.mAddVideo);
        mEditTextVideoTitle = findViewById(R.id.editTextVideoTitle);
        mEditTextVideoId = findViewById(R.id.editTextVideoId);
        TopicIdString = "1";


        mProgressBar = findViewById(R.id.progress_bar);
        mDatabase = FirebaseDatabase.getInstance();
        if (CourseId == 0) {
            mDatabaseRef = FirebaseDatabase.getInstance().getReference("video/ai/free");
        }
        Log.d(TAG, "Course: " + CourseId);


        Spinner spinner1 = (Spinner) findViewById(R.id.CourseSpinnerForAdminPage);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.Course_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        Spinner spinner2 = (Spinner) findViewById(R.id.FreeSpinnerForAdminPage);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.PaidOrFree_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner3 = (Spinner) findViewById(R.id.TopicSpinnerForAdminPage);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(Testing.this,
                R.array.ai_topics_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                CourseId = parent.getSelectedItemPosition() + 1;
                String Course = parent.getItemAtPosition(pos).toString();
                Log.d(TAG, "Course222: " + CourseId);

                if(CourseId==1){
                    spinner3 = (Spinner) findViewById(R.id.TopicSpinnerForAdminPage);
                    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(Testing.this,
                            R.array.ai_topics_array, android.R.layout.simple_spinner_item);
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner3.setAdapter(adapter3);
                }else if(CourseId==2)
                {
                    spinner3 = (Spinner) findViewById(R.id.TopicSpinnerForAdminPage);
                    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(Testing.this,
                            R.array.web_topics_array, android.R.layout.simple_spinner_item);
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner3.setAdapter(adapter3);
                }else if(CourseId==3)
                {
                    spinner3 = (Spinner) findViewById(R.id.TopicSpinnerForAdminPage);
                    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(Testing.this,
                            R.array.app_topics_array, android.R.layout.simple_spinner_item);
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner3.setAdapter(adapter3);
                }else if(CourseId==4)
                {
                    spinner3 = (Spinner) findViewById(R.id.TopicSpinnerForAdminPage);
                    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(Testing.this,
                            R.array.mach_topics_array, android.R.layout.simple_spinner_item);
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner3.setAdapter(adapter3);
                }else if(CourseId==5)
                {
                    spinner3 = (Spinner) findViewById(R.id.TopicSpinnerForAdminPage);
                    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(Testing.this,
                            R.array.uiux_topics_array, android.R.layout.simple_spinner_item);
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner3.setAdapter(adapter3);
                }else if(CourseId==6)
                {
                    spinner3 = (Spinner) findViewById(R.id.TopicSpinnerForAdminPage);
                    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(Testing.this,
                            R.array.iot_topics_array, android.R.layout.simple_spinner_item);
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner3.setAdapter(adapter3);
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                PaidId = parent.getSelectedItemPosition();
                String Paid = parent.getItemAtPosition(position).toString();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                TopicId = parent.getSelectedItemPosition()+1;
                String Topic = parent.getItemAtPosition(position).toString();
                Log.d(TAG, "Topic123: " + TopicId);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        Log.d(TAG, "Course123: " + CourseId);


        ValueEventListener valueEventListener1 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d(TAG, "Course123: " + CourseId);
                Log.d(TAG, "Number of children: " + dataSnapshot.getChildrenCount());
                childCount = (int) dataSnapshot.getChildrenCount();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String free = ds.getKey();
                    Log.d(TAG, free);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
            }
        };
        mDatabaseRef.addValueEventListener(valueEventListener1);


        mAddVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "TopicId: " + TopicId);


                Log.d(TAG, "Number: " + childCount);

                childCounter();
                Log.d(TAG, "Course1: " + CourseId);


                StartActivity();
            }
        });


    }

    private void StartActivity() {
        Intent intent = new Intent(Testing.this, Testing.class);
        startActivity(intent);
        finish();
    }

    private void childCounter() {
        if (CourseId == 1) {
            mDatabaseRef = FirebaseDatabase.getInstance().getReference("video/ai/free");
            ValueEventListener valueEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    childCount = (int) dataSnapshot.getChildrenCount();
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String free = ds.getKey();
                        Log.d(TAG, free);

                        UploadVideo uploadVideo = new UploadVideo(CourseId, PaidId, (int) (childCount + 1), mEditTextVideoTitle.getText().toString(), TopicId, mEditTextVideoId.getText().toString());
                        mDatabaseRef.child(String.valueOf(childCount + 1)).setValue(uploadVideo);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
                }
            };
            mDatabaseRef.addListenerForSingleValueEvent(valueEventListener);
        } else if (CourseId == 2) {
            mDatabaseRef = FirebaseDatabase.getInstance().getReference("video/web/free");
            ValueEventListener valueEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    childCount = (int) dataSnapshot.getChildrenCount();
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String free = ds.getKey();
                        Log.d(TAG, free);

                        UploadVideo uploadVideo = new UploadVideo(CourseId, PaidId, (int) (childCount + 1), mEditTextVideoTitle.getText().toString(), TopicId, mEditTextVideoId.getText().toString());
                        mDatabaseRef.child(String.valueOf(childCount + 1)).setValue(uploadVideo);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
                }
            };
            mDatabaseRef.addListenerForSingleValueEvent(valueEventListener);
        } else if (CourseId == 3) {
            mDatabaseRef = FirebaseDatabase.getInstance().getReference("video/app/free");
            ValueEventListener valueEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    childCount = (int) dataSnapshot.getChildrenCount();
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String free = ds.getKey();
                        Log.d(TAG, free);

                        UploadVideo uploadVideo = new UploadVideo(CourseId, PaidId, (int) (childCount + 1), mEditTextVideoTitle.getText().toString(), TopicId, mEditTextVideoId.getText().toString());
                        mDatabaseRef.child(String.valueOf(childCount + 1)).setValue(uploadVideo);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
                }
            };
            mDatabaseRef.addListenerForSingleValueEvent(valueEventListener);
        } else if (CourseId == 4) {
            mDatabaseRef = FirebaseDatabase.getInstance().getReference("video/mech/free");
            ValueEventListener valueEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    childCount = (int) dataSnapshot.getChildrenCount();
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String free = ds.getKey();
                        Log.d(TAG, free);

                        UploadVideo uploadVideo = new UploadVideo(CourseId, PaidId, (int) (childCount + 1), mEditTextVideoTitle.getText().toString(), TopicId, mEditTextVideoId.getText().toString());
                        mDatabaseRef.child(String.valueOf(childCount + 1)).setValue(uploadVideo);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
                }
            };
            mDatabaseRef.addListenerForSingleValueEvent(valueEventListener);
        } else if (CourseId == 5) {
            mDatabaseRef = FirebaseDatabase.getInstance().getReference("video/uiux/free");
            ValueEventListener valueEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    childCount = (int) dataSnapshot.getChildrenCount();
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String free = ds.getKey();
                        Log.d(TAG, free);

                        UploadVideo uploadVideo = new UploadVideo(CourseId, PaidId, (int) (childCount + 1), mEditTextVideoTitle.getText().toString(), TopicId, mEditTextVideoId.getText().toString());
                        mDatabaseRef.child(String.valueOf(childCount + 1)).setValue(uploadVideo);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
                }
            };
            mDatabaseRef.addListenerForSingleValueEvent(valueEventListener);
        } else if (CourseId == 6) {
            mDatabaseRef = FirebaseDatabase.getInstance().getReference("video/iot/free");
            ValueEventListener valueEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    childCount = (int) dataSnapshot.getChildrenCount();
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String free = ds.getKey();
                        Log.d(TAG, free);

                        UploadVideo uploadVideo = new UploadVideo(CourseId, PaidId, (int) (childCount + 1), mEditTextVideoTitle.getText().toString(), TopicId, mEditTextVideoId.getText().toString());
                        mDatabaseRef.child(String.valueOf(childCount + 1)).setValue(uploadVideo);
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
}