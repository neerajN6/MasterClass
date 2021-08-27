package com.athrved.masterclass;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UiuxActivity extends AppCompatActivity {

    LinearLayout all_layoutList;
    ImageView all_imgbig;
    ImageView all_imgsmall;
    TextView all_title;
    TextView all_channel;
    TextView all_author;
    TextView abcde;

    RecyclerView dataList2;
    List<String> titles2;
    List<Integer> images2;
    ImgAdapter2 imgAdapter2;

    RecyclerView popRecycler;
    RecyclerView.Adapter adapter1;

    RecyclerView freeRecycler;
    RecyclerView.Adapter adapter2;

    RecyclerView menRecycler;
    RecyclerView.Adapter adapter3;

    ArrayList<UiuxAllClasses> allCourseList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiux);

        getSupportActionBar().setTitle("UI UX Design");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.greyy)));

        popRecycler=findViewById(R.id.r1popclass);
        featuredRecycler();
        freeRecycler=findViewById(R.id.r1freeclass);
        freeturedRecycler();
        menRecycler=findViewById(R.id.r3menclass);
        mentoredRecycler();

        dataList2 = findViewById(R.id.dataList2);

        titles2 = new ArrayList<>();
        images2 = new ArrayList<>();

        titles2.add("Visual Design");
        titles2.add("UX Design");
        titles2.add("Motion Design");
        titles2.add("Prototyping");
        titles2.add("3D Design");
        titles2.add("Webflow");

        images2.add(R.drawable.visuald_logo);
        images2.add(R.drawable.uiux_logo);
        images2.add(R.drawable.motiond_logo);
        images2.add(R.drawable.mach_logo);
        images2.add(R.drawable.threed_logo);
        images2.add(R.drawable.iot_logo);

        imgAdapter2 = new ImgAdapter2(this,titles2,images2);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        dataList2.setLayoutManager(gridLayoutManager);
        dataList2.setAdapter(imgAdapter2);

        all_layoutList=findViewById(R.id.layout_list);

        abcde=findViewById(R.id.abcde);

        UiuxAllClasses a1=new UiuxAllClasses();
        a1.setAuthor("Goutham Naik");
        a1.setChannel("WEBFLOW");
        a1.setTitle("Playing with Grid-\nWeb Design Fundamentals");
        a1.setImagebig(R.drawable.webflow_l);
        a1.setImagesmall(R.drawable.ai_logo);
        allCourseList.add(a1);

        UiuxAllClasses a2=new UiuxAllClasses();
        a2.setAuthor("Abhinav Chikkara");
        a2.setChannel("PROTOTYPING\n");
        a2.setTitle("Protopie for Prototyping");
        a2.setImagebig(R.drawable.protopie_l);
        a2.setImagesmall(R.drawable.ai_logo);
        allCourseList.add(a2);
        UiuxAllClasses a3=new UiuxAllClasses();
        a3.setAuthor("S.M Sudhanva Acharya");
        a3.setChannel("MOTION DESIGN");
        a3.setTitle("Introduction to After Effects\nand Lottie Files");
        a3.setImagebig(R.drawable.afepluslot_l);
        a3.setImagesmall(R.drawable.ai_logo);
        allCourseList.add(a3);
        
        for(int i=0;i<allCourseList.size();i++) {
            addView(allCourseList.get(i).getAuthor(), allCourseList.get(i).getChannel(), allCourseList.get(i).getTitle(), allCourseList.get(i).getImagebig(), allCourseList.get(i).getImagesmall());
        }

    }



    private void addView(String auth, String channel,String title, int imgbig, int imgsmall) {
        View allCoursesview = getLayoutInflater().inflate(R.layout.add_all_classes, null, false);
        all_layoutList.addView(allCoursesview);

        all_imgbig=allCoursesview.findViewById(R.id.add_course_image);
        all_imgsmall=allCoursesview.findViewById(R.id.allc_image);
        all_title=allCoursesview.findViewById(R.id.allc_title);
        all_channel=allCoursesview.findViewById(R.id.allc_topic);
        all_author=allCoursesview.findViewById(R.id.allc_author);

        all_title.setText(title);
        all_channel.setText(channel);
        all_author.setText(auth);
        all_imgbig.setImageResource(imgbig);
        all_imgsmall.setImageResource(imgsmall);


    }

    private void featuredRecycler(){
        popRecycler.setHasFixedSize(true);
        popRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<PopHelperClass> popLocatio = new ArrayList<>();

        popLocatio.add(new PopHelperClass(R.drawable.secndone, R.drawable.ai_logo,0,"Color and Color Theory -\nFundamentals of Visual Design","VISUAL DESIGN","Goutham Naik"));
        popLocatio.add(new PopHelperClass(R.drawable.firstone, R.drawable.ai_logo, R.drawable.motiond_logo,"Color and Color Theory -\nFundamentals of Visual Design","UX DESIGN","  Goutham Naik, S. M. Sudhanva Acharya"));


        adapter1=new PopclassesAdapter(popLocatio);
         popRecycler.setAdapter(adapter1);

    }

    private void freeturedRecycler(){
        freeRecycler.setHasFixedSize(true);
        freeRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FreeHelperClass> freeLocatio = new ArrayList<>();

        freeLocatio.add(new FreeHelperClass(R.drawable.fourthone, R.drawable.ai_logo,0,"Introduction to UI UX Design\nFundamentals and Basics","VISUAL DESIGN","S M Sudhanva Acharya"));
        freeLocatio.add(new FreeHelperClass(R.drawable.thirdone, R.drawable.ai_logo,0,"White Space in Design","VISUAL DESIGN\n","Abhinav Chikkara"));


        adapter2=new FreeclassesAdapter(freeLocatio);
        freeRecycler.setAdapter(adapter2);

    }

    private void mentoredRecycler(){
        menRecycler.setHasFixedSize(true);
        menRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MenHelperClass> menLocatio = new ArrayList<>();

        menLocatio.add(new MenHelperClass(R.drawable.oneman,"Goutam Naik","CEO, AthrV-Ed"));
        menLocatio.add(new MenHelperClass(R.drawable.twoman,"S M Sudhanva Acharya", "Product Designer, AthrV-Ed"));
        menLocatio.add(new MenHelperClass(R.drawable.threeman,"Abhinav Chikkara", "Founder, 10kilogram"));

        adapter2=new MenAdapter(menLocatio);
        menRecycler.setAdapter(adapter2);

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