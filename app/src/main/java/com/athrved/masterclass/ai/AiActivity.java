package com.athrved.masterclass.ai;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.athrved.masterclass.AdminSignIn;
import com.athrved.masterclass.AdminSignUp;
import com.athrved.masterclass.BookmarkedVideos;
import com.athrved.masterclass.FetchData;
import com.athrved.masterclass.ImagesActivity;
import com.athrved.masterclass.LogOut;
import com.athrved.masterclass.MainActivity;
import com.athrved.masterclass.R;
import com.athrved.masterclass.UpdateProfile;
import com.athrved.masterclass.appdev.AppDevActivity;
import com.athrved.masterclass.uiux.FewAllAdapter;
import com.athrved.masterclass.uiux.FewAllHelperClass;
import com.athrved.masterclass.uiux.FreeHelperClass;
import com.athrved.masterclass.uiux.FreeclassesAdapter;
import com.athrved.masterclass.uiux.MenAdapter;
import com.athrved.masterclass.uiux.MenHelperClass;
import com.athrved.masterclass.uiux.PopHelperClass;
import com.athrved.masterclass.uiux.PopclassesAdapter;
import com.athrved.masterclass.uiux.UiuxActivity;
import com.athrved.masterclass.webdevelopment.WebActivity;
import com.athrved.masterclass.webdevelopment.WebFewAllAdapter;
import com.athrved.masterclass.webdevelopment.WebFewAllHelperClass;
import com.athrved.masterclass.webdevelopment.WebTopicsActivity;
import com.athrved.masterclass.webdevelopment.WebTopicsActivity2;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class AiActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView abcde;
    TextView ak;
    String tit;
    String urlname,videoID,tita;
    Button learnMoreButton;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextView viewAllMentorsTv;

    RecyclerView dataList2;
    List<String> titles2;
    List<Integer> images2;
    AiImgAdapter2 AiimgAdapter2;

    RecyclerView popRecycler;
    RecyclerView.Adapter adapter1;

    RecyclerView freeRecycler;
    RecyclerView.Adapter adapter2;

    RecyclerView menRecycler;
    RecyclerView.Adapter adapter3;

    RecyclerView allFewRecycler;
    RecyclerView.Adapter adapter4;

    ArrayList uiuxtopics;
    TextView viewall;

    public int callla=0;

//    ArrayList<UiuxAllClasses> allCourseList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        viewall = findViewById(R.id.viewall_allclass_ai);
        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vac = new Intent(AiActivity.this, AiTopicsActivity2.class);
                callla=1;
                vac.putExtra("vacai", "vac");
                startActivity(vac);
            }
        });


        viewAllMentorsTv = findViewById(R.id.viewAllMentorsTv);
        viewAllMentorsTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AiActivity.this, ImagesActivity.class);
                startActivity(intent);
            }
        });

        setSupportActionBar(toolbar);

        navigationView.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        //getSupportActionBar().setTitle("Artificial Intelligence");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.greyy)));


        popRecycler = findViewById(R.id.r1popclass_ai);
        featuredRecycler();
        freeRecycler=findViewById(R.id.r1freeclass_ai);
        freeturedRecycler();
        menRecycler=findViewById(R.id.r3menclass_ai);
        mentoredRecycler();
        allFewRecycler=findViewById(R.id.r4fewalllist_ai);
        allfewRecycler();
        learnMoreButton = findViewById(R.id.learnMoreBtn);
        learnMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AiActivity.this, AiMainActivity.class);
                startActivity(intent);
            }
        });

        dataList2 = findViewById(R.id.dataList2_ai);

        abcde = findViewById(R.id.tvv1_ai);
        ak=findViewById(R.id.ak_ai);

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

        AiimgAdapter2 = new AiImgAdapter2(this,titles2,images2);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        dataList2.setLayoutManager(gridLayoutManager);
        dataList2.setAdapter(AiimgAdapter2);

    }

    public void viewallallclasses_ai(View v){
        Intent vac=new Intent(AiActivity.this, AiTopicsActivity.class);
        callla=1;
        vac.putExtra("vacai", "vac");
        startActivity(vac);
    }

    private void featuredRecycler(){

        FetchData fetchData = new FetchData();
        fetchData.execute();

        popRecycler.setHasFixedSize(true);
        popRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<AiPopHelperClass> popLocatio = new ArrayList<>();

        popLocatio.add(new AiPopHelperClass(R.drawable.secndone, R.drawable.ai_logo,0,"Color and Color Theory -\nFundamentals of Visual Design","VISUAL DESIGN","Goutham Naik","Um3BhY0oS2c"));
        popLocatio.add(new AiPopHelperClass(R.drawable.firstone, R.drawable.ai_logo, R.drawable.motiond_logo,"Color and Color Theory -\nFundamentals of Visual Design","UX DESIGN","  Goutham Naik, S. M. Sudhanva Acharya","_vAmKNin0QM"));


        adapter1=new AiPopclassesAdapter(popLocatio);
        popRecycler.setAdapter(adapter1);

    }

    private void freeturedRecycler(){
        freeRecycler.setHasFixedSize(true);
        freeRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<AiFreeHelperClass> freeLocatio = new ArrayList<>();

        freeLocatio.add(new AiFreeHelperClass(R.drawable.ai_logo,0,"Top UX Design Interview Questions","VISUAL DESIGN","S M Sudhanva Acharya"));
        freeLocatio.add(new AiFreeHelperClass(R.drawable.ai_logo,0,"White Space in Design","VISUAL DESIGN","Abhinav Chikkara"));


        adapter2=new AiFreeClassesAdapter(freeLocatio);
        freeRecycler.setAdapter(adapter2);

    }

    private void mentoredRecycler(){
        menRecycler.setHasFixedSize(true);
        menRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<AiMenHelperClass> menLocatio = new ArrayList<>();

        menLocatio.add(new AiMenHelperClass(R.drawable.oneman,"Goutam Naik","CEO, AthrV-Ed"));
        menLocatio.add(new AiMenHelperClass(R.drawable.twoman,"S M Sudhanva Acharya", "Product Designer, AthrV-Ed"));
        menLocatio.add(new AiMenHelperClass(R.drawable.threeman,"Abhinav Chikkara", "Founder, 10kilogram"));

        adapter2=new AiMenAdapter(menLocatio);
        menRecycler.setAdapter(adapter2);

    }

    private void allfewRecycler(){
        MainActivity k = new MainActivity();
        k.getdatatotop();
        allFewRecycler.setHasFixedSize(true);
        allFewRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

 //       ArrayList<AiFewAllHelperClass> fewAllLocatio = new ArrayList<>();

        uiuxtopics = new ArrayList();
        uiuxtopics.add("VISUAL DESIGN");
        uiuxtopics.add("UX DESIGN");
        uiuxtopics.add("MOTION DESIGN");
        uiuxtopics.add("PROTOTYPING");
        uiuxtopics.add("3D DESIGN");
        uiuxtopics.add("WEBFLOW");

 //       fewAllLocatio.add(new AiFewAllHelperClass(R.drawable.webflow_l, R.drawable.ai_logo,k.vtitle.get(0),uiuxtopics.get((k.topic.get(0))).toString(),k.authorr.get(0)));
 //       fewAllLocatio.add(new AiFewAllHelperClass(R.drawable.webflow_l, R.drawable.ai_logo,k.vtitle.get(1),uiuxtopics.get((k.topic.get(1))).toString(),k.authorr.get(1)));
 //       fewAllLocatio.add(new AiFewAllHelperClass(R.drawable.webflow_l, R.drawable.ai_logo,k.vtitle.get(2),uiuxtopics.get((k.topic.get(2))).toString(),k.authorr.get(2)));

 //       adapter4=new AiFewAllAdapter(fewAllLocatio);
        allFewRecycler.setAdapter(adapter4);

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


    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch(menuItem.getItemId()){
            case R.id.nav_profile:
                Intent intent = new Intent(AiActivity.this, UpdateProfile.class);
                startActivity(intent);
                break;

            case R.id.nav_logout:
                Intent intent1 = new Intent(AiActivity.this, LogOut.class);
                startActivity(intent1);
                break;

            case R.id.nav_MyCourse:
                Intent intent2 = new Intent(AiActivity.this, AiCourseDesc.class);
                startActivity(intent2);
                break;

            case R.id.nav_bookmark:
                Intent intent3 = new Intent(AiActivity.this, BookmarkedVideos.class);
                startActivity(intent3);
                break;

            case R.id.nav_AdminAccess:
                Intent intent4 = new Intent(AiActivity.this, AdminSignIn.class);
                startActivity(intent4);
                break;

            case R.id.nav_MyMentors:
                Intent intent5 = new Intent(AiActivity.this, AiImagesActivity.class);
                startActivity(intent5);
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}