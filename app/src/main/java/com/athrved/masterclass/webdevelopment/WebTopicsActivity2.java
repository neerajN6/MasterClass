package com.athrved.masterclass.webdevelopment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.athrved.masterclass.MainActivity;
import com.athrved.masterclass.R;
import com.athrved.masterclass.VideoData;
import com.athrved.masterclass.webdevelopment.WebTopicAdapter;
import com.athrved.masterclass.webdevelopment.WebTopicAdapter2;
import com.athrved.masterclass.webdevelopment.WebTopicHelperClass;
import com.athrved.masterclass.webdevelopment.WebTopicHelperClass2;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class WebTopicsActivity2 extends AppCompatActivity {
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

    VideoData vv;

    RecyclerView topicfewRecycler;
    RecyclerView.Adapter adapter4t;

    List<Integer> uiuxslno;
    List<Integer> appslno;
    List<Integer> aislno;
    List<Integer> webslno;
    List<Integer> mechslno;
    List<Integer> iotslno;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    DatabaseReference reff;

    DatabaseReference reff5;
    DatabaseReference reff4;
    DatabaseReference reff3;
    DatabaseReference reff2;
    DatabaseReference reff1;
    DatabaseReference reff6;

    String getadaptpos;
    String getcoursepos;

    ArrayList<String> videoIds;
    ArrayList<String> vtitle;
    ArrayList<String> authorr;
    ArrayList<Integer> topic;
    ArrayList<Integer> course_id;
    ArrayList<Integer> paid;
    ArrayList<Integer> slno;
    MainActivity k;
    String calll;
    ArrayList<WebTopicHelperClass2> fewAllLocatio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        videoIds = new ArrayList<>();
        course_id = new ArrayList<>();
        paid = new ArrayList<>();
        vtitle = new ArrayList<>();
        slno = new ArrayList<>();
        topic = new ArrayList<>();
        authorr = new ArrayList<>();

        getadaptpos = getIntent().getStringExtra("topic");
        getcoursepos = getIntent().getStringExtra("course");

        p = findViewById(R.id.p);

        calll = getIntent().getStringExtra("vacweb");

        getDataFromBottom();
        rootNode = FirebaseDatabase.getInstance();

        MainActivity k = new MainActivity();
        k.getdatatotop();

        p.setText(getadaptpos);

        topicfewRecycler = findViewById(R.id.adderallc);

        topicfewRecycler.setHasFixedSize(true);
        topicfewRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        fewAllLocatio = new ArrayList<>();

        if (calll != null && calll.equals("vac")) {
            for (int i = 0; i < k.videoIds.size(); i++) {
                if (k.course_id.get(i) == 2)
                    fewAllLocatio.add(new WebTopicHelperClass2(webtopics.get(k.topic.get(i)), k.vtitle.get(i), k.authorr.get(i), R.drawable.ai_logo, R.drawable.afepluslot_l));
            }
        }
//        if (getcoursepos != null && getcoursepos.equals(String.valueOf(2))) {
//            for (int i = 0; i < k.videoIds.size(); i++) {
//                if (k.topic.get(i) == Integer.parseInt(getadaptpos) && k.course_id.get(i) == Integer.parseInt(getcoursepos))
//                    fewAllLocatio.add(new WebTopicHelperClass(webtopics.get(Integer.parseInt(getadaptpos)), k.vtitle.get(i), k.authorr.get(i), R.drawable.ai_logo, R.drawable.afepluslot_l));
//            }
//        }

        adapter4t = new WebTopicAdapter2(fewAllLocatio);
        topicfewRecycler.setAdapter(adapter4t);

    }
    private void getDataFromBottom() {
        uiuxtopics = new ArrayList<>();
        aitopics = new ArrayList<>();
        webtopics = new ArrayList<>();
        mechtopics = new ArrayList<>();
        apptopics = new ArrayList<>();
        iottopics = new ArrayList<>();


        uiuxtopics.add("VISUAL DESIGN");
        uiuxtopics.add("UX DESIGN");
        uiuxtopics.add("MOTION DESIGN");
        uiuxtopics.add("PROTOTYPING");
        uiuxtopics.add("3D DESIGN");
        uiuxtopics.add("WEBFLOW");

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}