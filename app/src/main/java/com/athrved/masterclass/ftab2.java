package com.athrved.masterclass;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.athrved.masterclass.uiux.FreeHelperClass;
import com.athrved.masterclass.uiux.FreeclassesAdapter;

import java.util.ArrayList;

public class ftab2 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView foundRecycler;
    RecyclerView.Adapter adapter1;
    Button foundbut, foundedbut;

    private String mParam1;
    private String mParam2;

    public ftab2() {
    }


    public static ftab2 newInstance(String param1, String param2) {
        ftab2 fragment = new ftab2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }}
/**
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ftab2, container, false);
        foundbut= v.findViewById(R.id.foundbut);
        foundedbut=v.findViewById(R.id.foundedbut);
        foundRecycler =(RecyclerView) v.findViewById(R.id.r1foundation);
        foundationRecycler();


        foundbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foundRecycler.setVisibility(View.VISIBLE);
                foundbut.setVisibility(View.GONE);
                foundedbut.setVisibility(View.VISIBLE);
            }
        });

        foundedbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foundRecycler.setVisibility(View.GONE);
                foundbut.setVisibility(View.VISIBLE);
                foundedbut.setVisibility(View.GONE);
            }
        });



        return v;
    }

    private void foundationRecycler() {

            foundRecycler.setHasFixedSize(true);
            foundRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

            ArrayList<FoundHelperClass> freeLocatio = new ArrayList<>();

            freeLocatio.add(new FoundHelperClass(R.drawable.secndone, "Colour and Colour Theory - Fundamentals of Visual Design", "In this lesson, goutam explains everything you need to know about colours in UI/UX design. At the end he would also explain about the process of creating a colour palette."));
            freeLocatio.add(new FoundHelperClass(R.drawable.firstone, "Design in Everyday Life", "In this lesson, goutam explains everything you need to know about colours in UI/UX design. At the end he would also explain about the process of creating a colour palette."));

            adapter1 = new FoundclassesAdapter(freeLocatio);
            foundRecycler.setAdapter(adapter1);

    }
}*/