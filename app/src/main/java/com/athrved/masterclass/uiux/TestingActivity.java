package com.athrved.masterclass.uiux;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.athrved.masterclass.R;
import com.athrved.masterclass.UploadVideo;
import com.athrved.masterclass.ai.AiImageAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TestingActivity extends AppCompatActivity {
    DatabaseReference mDatabaseRef;
    int childCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing2);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("video/ai/free");

        ValueEventListener valueEventListener1 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
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

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                forLoop(); //call function!

            }
        }, 1000);

    }

    private void forLoop(){
        for(int i=1;i<=childCount;i++) {

            DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
            DatabaseReference projectDetailsRef = rootRef.child("video/ai/free").child(String.valueOf(i));
            ValueEventListener valueEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Long CourseId = dataSnapshot.child("courseId_v").getValue(Long.class);
                    Long Paid = dataSnapshot.child("paid").getValue(Long.class);
                    Long slno = dataSnapshot.child("slno").getValue(Long.class);
                    String titleVideo = dataSnapshot.child("title_video").getValue(String.class);
                    Long topicid = dataSnapshot.child("topicid").getValue(Long.class);
                    String videoId = dataSnapshot.child("video_Id").getValue(String.class);
                    Log.d("CourseId", String.valueOf(CourseId));
                    Log.d("Paid", String.valueOf(Paid));
                    Log.d("SlNo", String.valueOf(slno));
                    Log.d("TitleVideo", titleVideo);
                    Log.d("TopicId", String.valueOf(topicid));
                    Log.d("VideoId", videoId);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.d("TAG", databaseError.getMessage()); //Don't ignore potential errors!
                }
            };
            projectDetailsRef.addListenerForSingleValueEvent(valueEventListener);
        }
    }
}