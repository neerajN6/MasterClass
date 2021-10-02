package com.athrved.masterclass;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;

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

    public VideoData videoData;

    public ArrayList<String> videoIds;
    public ArrayList<String> vtitle;
    public ArrayList<String> authorr;
    public ArrayList<Integer> topic;
    public ArrayList<Integer> course_id;
    public ArrayList<Integer> paid;
    public ArrayList<Integer> slno;

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
        uploadNumbersData();

//        Intent i = new Intent(MainActivity.this,TopicsActivity.class);
//        i.putStringArrayListExtra("videoid",  videoIds);
//        i.putIntegerArrayListExtra("courseid", course_id);
//        i.putIntegerArrayListExtra("paid",  paid);
//        i.putStringArrayListExtra("vtitle", vtitle);
//        i.putIntegerArrayListExtra("slno",  slno);
//        i.putIntegerArrayListExtra("topic",topic);
//        i.putStringArrayListExtra("author",  authorr);
//


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
                    videoData = new VideoData(videoIds.get(i), vtitle.get(i), course_id.get(i), paid.get(i),slno.get(i),topic.get(i),authorr.get(i));
                    reference.child(String.valueOf(slno.get(i))).setValue(videoData);
                }
            }

            if(course_id.get(i)==3) {
                if(paid.get(i)==0) {
                    reference = rootNode.getReference("video").child("app").child("free");
                    videoData = new VideoData(videoIds.get(i), vtitle.get(i), course_id.get(i), paid.get(i),slno.get(i),topic.get(i),authorr.get(i));
                    reference.child(String.valueOf(slno.get(i))).setValue(videoData);
                }
            }

            if(course_id.get(i)==1) {
                if(paid.get(i)==0) {
                    reference = rootNode.getReference("video").child("ai").child("free");
                    videoData = new VideoData(videoIds.get(i), vtitle.get(i), course_id.get(i), paid.get(i),slno.get(i),topic.get(i),authorr.get(i));
                    reference.child(String.valueOf(slno.get(i))).setValue(videoData);
                }
            }

            if(course_id.get(i)==2) {
                if(paid.get(i)==0) {
                    reference = rootNode.getReference("video").child("web").child("free");
                    videoData = new VideoData(videoIds.get(i), vtitle.get(i), course_id.get(i), paid.get(i),slno.get(i),topic.get(i),authorr.get(i));
                    reference.child(String.valueOf(slno.get(i))).setValue(videoData);
                }
            }

            if(course_id.get(i)==4) {
                if(paid.get(i)==0) {
                    reference = rootNode.getReference("video").child("mech").child("free");
                    videoData = new VideoData(videoIds.get(i), vtitle.get(i), course_id.get(i), paid.get(i),slno.get(i),topic.get(i),authorr.get(i));
                    reference.child(String.valueOf(slno.get(i))).setValue(videoData);
                }
            }

            if(course_id.get(i)==6) {
                if(paid.get(i)==0) {
                    reference = rootNode.getReference("video").child("iot").child("free");
                    videoData = new VideoData(videoIds.get(i), vtitle.get(i), course_id.get(i), paid.get(i),slno.get(i),topic.get(i),authorr.get(i));
                    reference.child(String.valueOf(slno.get(i))).setValue(videoData);
                }
            }
        }
    }

    public void uploadNumbersData(){
        rootNode = FirebaseDatabase.getInstance();
        VideoData videoData;
        int ucount=0;
        int wcount=0;
        int appcount=0;
        int aicount=0;
        int mcount=0;
        int iotcount=0;
        for(int i=0;i<videoIds.size();i++) {
            if (course_id.get(i)==5)
                ucount+=1;
            if (course_id.get(i)==1)
                aicount+=1;
            if (course_id.get(i)==2)
                wcount+=1;
            if (course_id.get(i)==3)
                appcount+=1;
            if (course_id.get(i)==4)
                mcount+=1;
            if (course_id.get(i)==6)
                iotcount+=1;
        }

        reference = rootNode.getReference("video").child("numbers");
        reference.child(String.valueOf(course_id.get(5))).setValue(ucount);
        reference.child(String.valueOf(course_id.get(1))).setValue(aicount);
        reference.child(String.valueOf(course_id.get(2))).setValue(wcount);
        reference.child(String.valueOf(course_id.get(3))).setValue(appcount);
        reference.child(String.valueOf(course_id.get(4))).setValue(mcount);
        reference.child(String.valueOf(course_id.get(6))).setValue(iotcount);

    }

    //VIDEO DATA:
    public void getdatatotop() {
        videoIds = new ArrayList<>();
        course_id = new ArrayList<>();
        paid = new ArrayList<>();
        vtitle = new ArrayList<>();
        slno = new ArrayList<>();
        topic = new ArrayList<>();
        authorr=new ArrayList<>();




//  videoIds.add("");   course_id.add();    paid.add();     vtitle.add("");

//UIUX
    slno.add(1);    videoIds.add("SRec90j6lTY");    course_id.add(5);   paid.add(0);    authorr.add("Sudhanva");    topic.add(0);    vtitle.add("Adobe XD Tutorial | Login/Signup Page");
    slno.add(2);    videoIds.add("EBCn1btfX68");    course_id.add(5);   paid.add(0);    authorr.add("Sushmitha");    topic.add(0);    vtitle.add("How to Learn UI/UX DESIGN online for FREE? ");
    slno.add(3);    videoIds.add("SbS1jwm4U4o");    course_id.add(5);   paid.add(0);    authorr.add("Avish");    topic.add(5);    vtitle.add("What is User Experience");
    slno.add(4);    videoIds.add("OdSgDir6XKs");    course_id.add(5);   paid.add(0);    authorr.add("Goutham");     topic.add(0);    vtitle.add("User Experience Research");
    slno.add(5);    videoIds.add("JDMXgPCN-BM");    course_id.add(5);   paid.add(0);    authorr.add("Ankith");     topic.add(1);    vtitle.add("User Research Interviews");
    slno.add(6);    videoIds.add("UnAuwhu2C9Q");    course_id.add(5);   paid.add(0);    authorr.add("Prathamesh");     topic.add(2);    vtitle.add("User Persona for UX");
    slno.add(7);    videoIds.add("6C2Ye1makdY");    course_id.add(5);   paid.add(0);    authorr.add("Neeraj");    topic.add(3);    vtitle.add("Adobe XD how to Download and Install");
    slno.add(8);    videoIds.add("n7-atYzJKTA");    course_id.add(5);   paid.add(0);    authorr.add("Preetham");    topic.add(4);    vtitle.add("Adobe XD User Interface and Artboards");


//APP
    slno.add(1);    videoIds.add("TnTn6e4Pfn8");   course_id.add(3);    paid.add(0);      topic.add(0);  authorr.add("Sudhanva");  vtitle.add("How to become an Android Developer | Step by Step | Freelancing and Placement");
    slno.add(2);    videoIds.add("5soHbJrzuok");   course_id.add(3);    paid.add(0);      topic.add(0);  authorr.add("Avish");  vtitle.add("How Applications Are Made? | Android Development for Beginners | Basics of Android Development");
    slno.add(3);    videoIds.add("InigFUSiPl8");   course_id.add(3);    paid.add(0);      topic.add(0);  authorr.add("Sudhanva");  vtitle.add("Installing Android Studio & Setup | Android Tutorials in Hindi #1");
    slno.add(4);    videoIds.add("PoBePPh5Iko");   course_id.add(3);    paid.add(0);      topic.add(0);  authorr.add("Ankith");  vtitle.add("Creating Our First Android App (with APK) | Android Tutorials in Hindi #2");
    slno.add(5);    videoIds.add("HHaghq5wXic");   course_id.add(3);    paid.add(0);      topic.add(0);  authorr.add("Preetham");  vtitle.add("Linear Layout & Relative Layout In Android | Android Tutorials in Hindi #3");
    slno.add(6);    videoIds.add("jUmqYE2iWiI");   course_id.add(3);    paid.add(0);      topic.add(0);  authorr.add("Sudhanva");  vtitle.add("Android activity & Activity Lifecycle | Android Tutorials in Hindi #4");
    slno.add(7);    videoIds.add("WVjqX1BoQeM");   course_id.add(3);    paid.add(0);      topic.add(0);   authorr.add("Sudhanva"); vtitle.add("Project 1: Tic Tac Toe Game Android Game Development | Android Tutorials in Hindi #5");

//MECH
    slno.add(1);    videoIds.add("TnTn6e4Pfn8");   course_id.add(4);    paid.add(0);      topic.add(0);  authorr.add("Sudhanva");  vtitle.add("How to become an Android Developer | Step by Step | Freelancing and Placement");
    slno.add(2);    videoIds.add("5soHbJrzuok");   course_id.add(4);    paid.add(0);      topic.add(0);  authorr.add("Sudhanva");  vtitle.add("How Applications Are Made? | Android Development for Beginners | Basics of Android Development");
    slno.add(3);    videoIds.add("InigFUSiPl8");   course_id.add(4);    paid.add(0);      topic.add(0);  authorr.add("Sudhanva");  vtitle.add("Installing Android Studio & Setup | Android Tutorials in Hindi #1");
    slno.add(4);    videoIds.add("PoBePPh5Iko");   course_id.add(4);    paid.add(0);      topic.add(0);  authorr.add("Sudhanva");  vtitle.add("Creating Our First Android App (with APK) | Android Tutorials in Hindi #2");
    slno.add(5);    videoIds.add("HHaghq5wXic");   course_id.add(4);    paid.add(0);      topic.add(0);  authorr.add("Sudhanva");  vtitle.add("Linear Layout & Relative Layout In Android | Android Tutorials in Hindi #3");
    slno.add(6);    videoIds.add("jUmqYE2iWiI");   course_id.add(4);    paid.add(0);      topic.add(0);  authorr.add("Sudhanva"); vtitle.add("Android activity & Activity Lifecycle | Android Tutorials in Hindi #4");
    slno.add(7);    videoIds.add("WVjqX1BoQeM");   course_id.add(4);    paid.add(0);      topic.add(0);  authorr.add("Sudhanva"); vtitle.add("Project 1: Tic Tac Toe Game Android Game Development | Android Tutorials in Hindi #5");
//AI
        slno.add(1);    videoIds.add("TnTn6e4Pfn8");   course_id.add(1);    paid.add(0);      topic.add(0);  authorr.add("Sudhanva");  vtitle.add("How to become an Android Developer | Step by Step | Freelancing and Placement");
        slno.add(2);    videoIds.add("5soHbJrzuok");   course_id.add(1);    paid.add(0);      topic.add(0);  authorr.add("Sudhanva");  vtitle.add("How Applications Are Made? | Android Development for Beginners | Basics of Android Development");
        slno.add(3);    videoIds.add("InigFUSiPl8");   course_id.add(1);    paid.add(0);      topic.add(0);  authorr.add("Sudhanva");  vtitle.add("Installing Android Studio & Setup | Android Tutorials in Hindi #1");
        slno.add(4);    videoIds.add("PoBePPh5Iko");   course_id.add(1);    paid.add(0);      topic.add(0);  authorr.add("Sudhanva");  vtitle.add("Creating Our First Android App (with APK) | Android Tutorials in Hindi #2");
        slno.add(5);    videoIds.add("HHaghq5wXic");   course_id.add(1);    paid.add(0);      topic.add(0);  authorr.add("Sudhanva");  vtitle.add("Linear Layout & Relative Layout In Android | Android Tutorials in Hindi #3");
        slno.add(6);    videoIds.add("jUmqYE2iWiI");   course_id.add(1);    paid.add(0);      topic.add(0);  authorr.add("Sudhanva");  vtitle.add("Android activity & Activity Lifecycle | Android Tutorials in Hindi #4");
        slno.add(7);    videoIds.add("WVjqX1BoQeM");   course_id.add(1);    paid.add(0);      topic.add(0);  authorr.add("Sudhanva");  vtitle.add("Project 1: Tic Tac Toe Game Android Game Development | Android Tutorials in Hindi #5");

//WEB
        slno.add(1);    videoIds.add("TnTn6e4Pfn8");   course_id.add(2);    paid.add(0);      topic.add(0);   authorr.add("Sudhanva"); vtitle.add("How to become an Android Developer | Step by Step | Freelancing and Placement");
        slno.add(2);    videoIds.add("5soHbJrzuok");   course_id.add(2);    paid.add(0);      topic.add(0);   authorr.add("Sudhanva"); vtitle.add("How Applications Are Made? | Android Development for Beginners | Basics of Android Development");
        slno.add(3);    videoIds.add("InigFUSiPl8");   course_id.add(2);    paid.add(0);      topic.add(0);   authorr.add("Sudhanva"); vtitle.add("Installing Android Studio & Setup | Android Tutorials in Hindi #1");
        slno.add(4);    videoIds.add("PoBePPh5Iko");   course_id.add(2);    paid.add(0);      topic.add(0);   authorr.add("Sudhanva"); vtitle.add("Creating Our First Android App (with APK) | Android Tutorials in Hindi #2");
        slno.add(5);    videoIds.add("HHaghq5wXic");   course_id.add(2);    paid.add(0);      topic.add(0);   authorr.add("Sudhanva"); vtitle.add("Linear Layout & Relative Layout In Android | Android Tutorials in Hindi #3");
        slno.add(6);    videoIds.add("jUmqYE2iWiI");   course_id.add(2);    paid.add(0);      topic.add(0);   authorr.add("Sudhanva"); vtitle.add("Android activity & Activity Lifecycle | Android Tutorials in Hindi #4");
        slno.add(7);    videoIds.add("WVjqX1BoQeM");   course_id.add(2);    paid.add(0);      topic.add(0);   authorr.add("Sudhanva"); vtitle.add("Project 1: Tic Tac Toe Game Android Game Development | Android Tutorials in Hindi #5");

//IOT
        slno.add(1);    videoIds.add("TnTn6e4Pfn8");   course_id.add(6);    paid.add(0);      topic.add(0);   authorr.add("Sudhanva"); vtitle.add("How to become an Android Developer | Step by Step | Freelancing and Placement");
        slno.add(2);    videoIds.add("5soHbJrzuok");   course_id.add(6);    paid.add(0);      topic.add(0);   authorr.add("Sudhanva"); vtitle.add("How Applications Are Made? | Android Development for Beginners | Basics of Android Development");
        slno.add(3);    videoIds.add("InigFUSiPl8");   course_id.add(6);    paid.add(0);      topic.add(0);   authorr.add("Sudhanva"); vtitle.add("Installing Android Studio & Setup | Android Tutorials in Hindi #1");
        slno.add(4);    videoIds.add("PoBePPh5Iko");   course_id.add(6);    paid.add(0);      topic.add(0);   authorr.add("Sudhanva"); vtitle.add("Creating Our First Android App (with APK) | Android Tutorials in Hindi #2");
        slno.add(5);    videoIds.add("HHaghq5wXic");   course_id.add(6);    paid.add(0);      topic.add(0);   authorr.add("Sudhanva"); vtitle.add("Linear Layout & Relative Layout In Android | Android Tutorials in Hindi #3");
        slno.add(6);    videoIds.add("jUmqYE2iWiI");   course_id.add(6);    paid.add(0);      topic.add(0);   authorr.add("Sudhanva"); vtitle.add("Android activity & Activity Lifecycle | Android Tutorials in Hindi #4");
        slno.add(7);    videoIds.add("WVjqX1BoQeM");   course_id.add(6);    paid.add(0);      topic.add(0);   authorr.add("Sudhanva"); vtitle.add("Project 1: Tic Tac Toe Game Android Game Development | Android Tutorials in Hindi #5");



    }
}