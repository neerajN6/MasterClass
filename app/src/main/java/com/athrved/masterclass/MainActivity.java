package com.athrved.masterclass;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView dataList;
    List<String> titles;
    List<Integer> images;

    List<String> videoIds;
    List<String> vtitle;
    List<Integer> course_id;
    List<Integer> paid;
    List<Integer> slno;

    ImgAdapter imgAdapter;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataList = findViewById(R.id.dataList);

        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Database db = new Database();

        titles = new ArrayList<>();
        images = new ArrayList<>();

        getdatatotop();
        gettheFirebaseData();

        titles.add("Artificial\nIntelligence");
        titles.add("Web\nDevelopment");
        titles.add("App\nDevelopment");
        titles.add("Machine\nDesign");
        titles.add("UI/UX\nDesign");
        titles.add("Internet of\nThings");

        images.add(R.drawable.ai_logo);
        images.add(R.drawable.web_logo);
        images.add(R.drawable.appdev_logo);
        images.add(R.drawable.mach_logo);
        images.add(R.drawable.uiux_logo);
        images.add(R.drawable.iot_logo);


        imgAdapter = new ImgAdapter(this,titles,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(imgAdapter);





    }

    public void gettheFirebaseData(){
        rootNode = FirebaseDatabase.getInstance();


        VideoData videoData;
        for(int i=0;i<videoIds.size();i++) {
            if(course_id.get(i)==5) {
                if(paid.get(i)==0) {
                    reference = rootNode.getReference("video").child("uiux").child("free");
                    videoData = new VideoData(videoIds.get(i), vtitle.get(i), course_id.get(i), paid.get(i),slno.get(i));
                    reference.child(String.valueOf(slno.get(i))).setValue(videoData);
                }
            }

            if(course_id.get(i)==3) {
                if(paid.get(i)==0) {
                    reference = rootNode.getReference("video").child("app").child("free");
                    videoData = new VideoData(videoIds.get(i), vtitle.get(i), course_id.get(i), paid.get(i),slno.get(i));
                    reference.child(String.valueOf(slno.get(i))).setValue(videoData);
                }
            }


        }
    }

    //VIDEO DATA:
    public void getdatatotop() {
        videoIds = new ArrayList<>();
        course_id = new ArrayList<>();
        paid = new ArrayList<>();
        vtitle = new ArrayList<>();
        slno = new ArrayList<>();

//  videoIds.add("");   course_id.add();    paid.add();     vtitle.add("");
//UIUX
    slno.add(1);    videoIds.add("SRec90j6lTY");    course_id.add(5);   paid.add(0);    vtitle.add("Adobe XD Tutorial | Login/Signup Page | Basic Course of UI/UX Design");
    slno.add(2);    videoIds.add("EBCn1btfX68");    course_id.add(5);   paid.add(0);    vtitle.add("How to Learn UI/UX DESIGN online for FREE? (Explanation by a Designer");

//APP
    slno.add(1);    videoIds.add("TnTn6e4Pfn8");   course_id.add(3);    paid.add(0);      vtitle.add("How to become an Android Developer | Step by Step | Freelancing and Placement");
    slno.add(2);    videoIds.add("5soHbJrzuok");   course_id.add(3);    paid.add(0);      vtitle.add("How Applications Are Made? | Android Development for Beginners | Basics of Android Development");

    }
}