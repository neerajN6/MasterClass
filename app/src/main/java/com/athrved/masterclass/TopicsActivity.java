package com.athrved.masterclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TopicsActivity extends AppCompatActivity {
    List<String> uiuxtopics;
    List<String> apptopics;
    List<String> aitopics;
    List<String> webtopics;
    List<String> mechtopics;
    List<String> iottopics;

    int uiuxtot;
    int mtot;
    int webtot;
    int aitot;
    int apptot;
    int iottot;

    TextView p;

    List <Integer> uiuxslno;
    List <Integer> appslno;
    List <Integer> aislno;
    List <Integer> webslno;
    List <Integer> mechslno;
    List <Integer> iotslno;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    DatabaseReference reff;

    DatabaseReference reff5;
    DatabaseReference reff4;
    DatabaseReference reff3;
    DatabaseReference reff2;
    DatabaseReference reff1;
    DatabaseReference reff6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        p=findViewById(R.id.p);

        getDataFromBottom();
        rootNode = FirebaseDatabase.getInstance();
        uiuxslno = new ArrayList<>();

        for (int i = 0; i < uiuxtopics.size(); i++) {
            reference = rootNode.getReference("video").child("uiux").child("topics");
            uiuxslno.add(i);
            topicHelperClass topicHelperClass = new topicHelperClass(uiuxslno.get(i), uiuxtopics.get(i));
            reference.child(String.valueOf(uiuxslno.get(i))).setValue(topicHelperClass);
        }

        for (int k = 1; k <= 6; k++) {
            reff = FirebaseDatabase.getInstance().getReference("video").child("numbers");
            String ka = String.valueOf(k);
            int finalK = k;
            reff.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    uiuxtot =  Integer.parseInt(snapshot.child("5").getValue().toString());


                    for (int ku=1;ku<=uiuxtot;ku++){
                        reff5=FirebaseDatabase.getInstance().getReference("video").child("numbers").child("5");

                    }







                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }
    }

    private void getDataFromBottom() {
        uiuxtopics = new ArrayList<>();
        aitopics = new ArrayList<>();
        webtopics = new ArrayList<>();
        mechtopics = new ArrayList<>();
        apptopics = new ArrayList<>();
        iottopics = new ArrayList<>();


        uiuxtopics.add("Visual Design");
        uiuxtopics.add("UX Design");
        uiuxtopics.add("Motion Design");
        uiuxtopics.add("Prototyping");
        uiuxtopics.add("3D Design");
        uiuxtopics.add("Webflow");

        apptopics.add("Visual Design");
        apptopics.add("UX Design");
        apptopics.add("Motion Design");
        apptopics.add("Prototyping");
        apptopics.add("3D Design");
        apptopics.add("Webflow");

        aitopics.add("Visual Design");
        aitopics.add("UX Design");
        aitopics.add("Motion Design");
        aitopics.add("Prototyping");
        aitopics.add("3D Design");
        aitopics.add("Webflow");

        webtopics.add("Visual Design");
        webtopics.add("UX Design");
        webtopics.add("Motion Design");
        webtopics.add("Prototyping");
        webtopics.add("3D Design");
        webtopics.add("Webflow");

        mechtopics.add("Visual Design");
        mechtopics.add("UX Design");
        mechtopics.add("Motion Design");
        mechtopics.add("Prototyping");
        mechtopics.add("3D Design");
        mechtopics.add("Webflow");

        iottopics.add("Visual Design");
        iottopics.add("UX Design");
        iottopics.add("Motion Design");
        iottopics.add("Prototyping");
        iottopics.add("3D Design");
        iottopics.add("Webflow");

    }
}