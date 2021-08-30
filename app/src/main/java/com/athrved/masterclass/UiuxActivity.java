package com.athrved.masterclass;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UiuxActivity extends AppCompatActivity {

    public static TextView abcde;
    public static TextView ak;
    public static String tit;
    String urlname,videoID,tita;

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

    RecyclerView allFewRecycler;
    RecyclerView.Adapter adapter4;

    ArrayList<UiuxAllClasses> allCourseList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiux);

        getSupportActionBar().setTitle("UI UX Design");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.greyy)));

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
        freeLocatio.add(new FreeHelperClass(R.drawable.ai_logo,0,"White Space in Design","VISUAL DESIGN\n","Abhinav Chikkara"));


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
}