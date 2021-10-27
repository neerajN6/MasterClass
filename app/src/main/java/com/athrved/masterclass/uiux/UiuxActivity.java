package com.athrved.masterclass.uiux;

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
import com.athrved.masterclass.LogOut;
import com.athrved.masterclass.R;
import com.athrved.masterclass.UpdateProfile;
import com.athrved.masterclass.ai.AiActivity;
import com.athrved.masterclass.ai.AiCourseDesc;
import com.athrved.masterclass.ai.AiImagesActivity;
import com.athrved.masterclass.appdev.AppDevDesc;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class UiuxActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView abcde;
    TextView ak;
    String tit;
    String urlname,videoID,tita;

    RecyclerView dataList2;
    List<String> titles2;
    List<Integer> images2;
    Button learnMoreInUiux;
    TextView viewAllMentorsTv;


    List<String> videoid;
    List<String> titlev;
    List<Integer> courseidv;
    List<Integer> paid;

    ImgAdapter2 imgAdapter2;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    RecyclerView popRecycler;
    RecyclerView.Adapter adapter1;

    RecyclerView freeRecycler;
    RecyclerView.Adapter adapter2;

    RecyclerView menRecycler;
    RecyclerView.Adapter adapter3;

    RecyclerView allFewRecycler;
    RecyclerView.Adapter adapter4;

    FirebaseDatabase rootnode;
    DatabaseReference reference;

    ArrayList<UiuxFewAllClasses> allCourseList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiux);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view1);
        toolbar = findViewById(R.id.toolbar);
        viewAllMentorsTv = findViewById(R.id.viewAllMentorsTv);
        viewAllMentorsTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UiuxActivity.this,TestingActivity.class);
                startActivity(intent);
            }
        });
        learnMoreInUiux = findViewById(R.id.learnMoreInUiux);
        learnMoreInUiux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UiuxActivity.this,UiuxMainActivity.class);
                startActivity(intent);
            }
        });

        setSupportActionBar(toolbar);


        navigationView.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        //getSupportActionBar().setTitle("UI UX Design");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.greyy)));

//        videoID="_vAmKNin0QM";
//        urlname="https://noembed.com/embed?url=https://www.youtube.com/watch?v="+videoID;
//        tita= respo(urlname);


        popRecycler = findViewById(R.id.r1popclass);
        featuredRecycler();
        freeRecycler=findViewById(R.id.r1freeclass);
        freeturedRecycler( tit);
        menRecycler=findViewById(R.id.r3menclass);
        mentoredRecycler();
        allFewRecycler=findViewById(R.id.r4fewalllist);
        allfewRecycler();

        dataList2 = findViewById(R.id.dataList2);

        abcde = findViewById(R.id.tvv1);
        ak=findViewById(R.id.ak);

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

    }



    private void featuredRecycler(){

        FetchData fetchData = new FetchData();
        fetchData.execute();

        popRecycler.setHasFixedSize(true);
        popRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<PopHelperClass> popLocatio = new ArrayList<>();

        popLocatio.add(new PopHelperClass(R.drawable.secndone, R.drawable.ai_logo,0,"Color and Color Theory -\nFundamentals of Visual Design","VISUAL DESIGN","Goutham Naik","Um3BhY0oS2c"));
        popLocatio.add(new PopHelperClass(R.drawable.firstone, R.drawable.ai_logo, R.drawable.motiond_logo,"Color and Color Theory -\nFundamentals of Visual Design","UX DESIGN","  Goutham Naik, S. M. Sudhanva Acharya","_vAmKNin0QM"));


        adapter1=new PopclassesAdapter(popLocatio);
         popRecycler.setAdapter(adapter1);

    }

    private void freeturedRecycler(String tita){
        freeRecycler.setHasFixedSize(true);
        freeRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FreeHelperClass> freeLocatio = new ArrayList<>();

        freeLocatio.add(new FreeHelperClass(R.drawable.ai_logo,0,"Top UX Design Interview Questions","VISUAL DESIGN","S M Sudhanva Acharya"));
        freeLocatio.add(new FreeHelperClass(R.drawable.ai_logo,0,"White Space in Design","VISUAL DESIGN","Abhinav Chikkara"));


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

    private void allfewRecycler(){
        allFewRecycler.setHasFixedSize(true);
        allFewRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<FewAllHelperClass> fewAllLocatio = new ArrayList<>();

        fewAllLocatio.add(new FewAllHelperClass(R.drawable.webflow_l, R.drawable.ai_logo,"Playing with Grid-\nWeb Design Fundamentals","WEBFLOW","Goutham Naik"));
        fewAllLocatio.add(new FewAllHelperClass(R.drawable.protopie_l, R.drawable.ai_logo,"Protopie for Prototyping","PROTOTYPING\n","Abhinav Chikkara"));
        fewAllLocatio.add(new FewAllHelperClass(R.drawable.afepluslot_l, R.drawable.ai_logo,"Introduction to After Effects\nand Lottie Files","MOTION DESIGN","S.M Sudhanva Acharya"));

        adapter4=new FewAllAdapter(fewAllLocatio);
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
                Intent intent = new Intent(UiuxActivity.this, UpdateProfile.class);
                startActivity(intent);
                break;

            case R.id.nav_logout:
                Intent intent1 = new Intent(UiuxActivity.this, LogOut.class);
                startActivity(intent1);
                break;

            case R.id.nav_MyCourse:
                Intent intent2 = new Intent(UiuxActivity.this, UiuxDesc.class);
                startActivity(intent2);
                break;

            case R.id.nav_bookmark:
                Intent intent3 = new Intent(UiuxActivity.this, BookmarkedVideos.class);
                startActivity(intent3);
                break;

            case R.id.nav_AdminAccess:
                Intent intent4 = new Intent(UiuxActivity.this, AdminSignIn.class);
                startActivity(intent4);
                break;

            case R.id.nav_MyMentors:
                Intent intent5 = new Intent(UiuxActivity.this, UiuxImagesActivity.class);
                startActivity(intent5);
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }





}