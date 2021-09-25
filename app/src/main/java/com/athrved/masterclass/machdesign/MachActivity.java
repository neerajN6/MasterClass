package com.athrved.masterclass.machdesign;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
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

import com.athrved.masterclass.BookmarkedVideos;
import com.athrved.masterclass.FetchData;
import com.athrved.masterclass.LogOut;
import com.athrved.masterclass.R;
import com.athrved.masterclass.UpdateProfile;
import com.athrved.masterclass.ai.AiCourseDesc;
import com.athrved.masterclass.uiux.FewAllAdapter;
import com.athrved.masterclass.uiux.FewAllHelperClass;
import com.athrved.masterclass.uiux.FreeHelperClass;
import com.athrved.masterclass.uiux.FreeclassesAdapter;
import com.athrved.masterclass.uiux.MenAdapter;
import com.athrved.masterclass.uiux.MenHelperClass;
import com.athrved.masterclass.uiux.PopHelperClass;
import com.athrved.masterclass.uiux.PopclassesAdapter;
import com.athrved.masterclass.uiux.UiuxActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MachActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView abcde;
    TextView ak;
    String tit;
    String urlname,videoID,tita;

    RecyclerView dataList2;
    List<String> titles2;
    List<Integer> images2;
    MImgAdapter2 MimgAdapter2;
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

//    ArrayList<UiuxAllClasses> allCourseList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mach);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        //getSupportActionBar().setTitle("Machine Design");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.greyy)));


        popRecycler = (RecyclerView) findViewById(R.id.r1popclass_m);
        featuredRecycler();
        freeRecycler=findViewById(R.id.r1freeclass_m);
        freeturedRecycler();
        menRecycler=findViewById(R.id.r3menclass_m);
        mentoredRecycler();
        allFewRecycler=findViewById(R.id.r4fewalllist_m);
        allfewRecycler();

        dataList2 = findViewById(R.id.dataList2_m);

        abcde = findViewById(R.id.tvv1_m);
        ak=findViewById(R.id.ak_m);

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

        MimgAdapter2 = new MImgAdapter2(this,titles2,images2);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        dataList2.setLayoutManager(gridLayoutManager);
        dataList2.setAdapter(MimgAdapter2);

    }



    private void featuredRecycler(){

        FetchData fetchData = new FetchData();
        fetchData.execute();

        popRecycler.setHasFixedSize(true);
        popRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MPopHelperClass> popLocatio = new ArrayList<>();

        popLocatio.add(new MPopHelperClass(R.drawable.secndone, R.drawable.ai_logo,0,"Color and Color Theory -\nFundamentals of Visual Design","VISUAL DESIGN","Goutham Naik","Um3BhY0oS2c"));
        popLocatio.add(new MPopHelperClass(R.drawable.firstone, R.drawable.ai_logo, R.drawable.motiond_logo,"Color and Color Theory -\nFundamentals of Visual Design","UX DESIGN","  Goutham Naik, S. M. Sudhanva Acharya","_vAmKNin0QM"));


        adapter1=new MPopclassesAdapter(popLocatio);
        popRecycler.setAdapter(adapter1);

    }

    private void freeturedRecycler(){

        freeRecycler.setHasFixedSize(true);
        freeRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MFreeHelperClass> freeLocatio = new ArrayList<>();

        freeLocatio.add(new MFreeHelperClass(R.drawable.ai_logo,0,"Top UX Design Interview Questions","VISUAL DESIGN","S M Sudhanva Acharya"));
        freeLocatio.add(new MFreeHelperClass(R.drawable.ai_logo,0,"White Space in Design","VISUAL DESIGN","Abhinav Chikkara"));

        adapter2=new MFreeClassesAdapter(freeLocatio);
        freeRecycler.setAdapter(adapter2);

    }

    private void mentoredRecycler(){
        menRecycler.setHasFixedSize(true);
        menRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MMenHelperClass> menLocatio = new ArrayList<>();

        menLocatio.add(new MMenHelperClass(R.drawable.oneman,"Goutam Naik","CEO, AthrV-Ed"));
        menLocatio.add(new MMenHelperClass(R.drawable.twoman,"S M Sudhanva Acharya", "Product Designer, AthrV-Ed"));
        menLocatio.add(new MMenHelperClass(R.drawable.threeman,"Abhinav Chikkara", "Founder, 10kilogram"));

        adapter2=new MMenAdapter(menLocatio);
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
                Intent intent = new Intent(MachActivity.this, UpdateProfile.class);
                startActivity(intent);
                break;

            case R.id.nav_logout:
                Intent intent1 = new Intent(MachActivity.this, LogOut.class);
                startActivity(intent1);
                break;

            case R.id.nav_MyCourse:
                Intent intent2 = new Intent(MachActivity.this, AiCourseDesc.class);
                startActivity(intent2);
                break;

            case R.id.nav_bookmark:
                Intent intent3 = new Intent(MachActivity.this, BookmarkedVideos.class);
                startActivity(intent3);
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}