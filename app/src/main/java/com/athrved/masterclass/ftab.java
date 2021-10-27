package com.athrved.masterclass;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class ftab extends Fragment {

     public TextView l;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ftab() {
        // Required empty public constructor
    }}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ftab.
     */
    // TODO: Rename and change types and number of parameters
  /**  public static ftab newInstance(String param1, String param2) {
        ftab fragment = new ftab();
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
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final LinearLayout expand1;
        final Button btn1;
        final CardView card1;

        final LinearLayout expand2;
        final Button btn2;
        final CardView card2;

        final LinearLayout expand3;
        final Button btn3;
        final CardView card3;

        View v = inflater.inflate(R.layout.fragment_ftab, container, false);

        expand1 = v.findViewById(R.id.expanded_lay1);
        btn1 = v.findViewById(R.id.but_q_exp_lay1);
        card1 = v.findViewById(R.id.faq_1);

        expand2 = v.findViewById(R.id.expanded_lay2);
        btn2 = v.findViewById(R.id.but_q_exp_lay2);
        card2 = v.findViewById(R.id.faq_2);

        expand3 = v.findViewById(R.id.expanded_lay3);
        btn3 = v.findViewById(R.id.but_q_exp_lay3);
        card3 = v.findViewById(R.id.faq_3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(expand1.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(card1, new AutoTransition());
                    expand1.setVisibility(View.VISIBLE);
                    btn1.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                }else{
                    TransitionManager.beginDelayedTransition(card1, new AutoTransition());
                    expand1.setVisibility(View.GONE);
                    btn1.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(expand2.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(card2, new AutoTransition());
                    expand2.setVisibility(View.VISIBLE);
                    btn2.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                }else{
                    TransitionManager.beginDelayedTransition(card2, new AutoTransition());
                    expand2.setVisibility(View.GONE);
                    btn2.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(expand3.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(card3, new AutoTransition());
                    expand3.setVisibility(View.VISIBLE);
                    btn3.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                }else{
                    TransitionManager.beginDelayedTransition(card3, new AutoTransition());
                    expand3.setVisibility(View.GONE);
                    btn3.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }
            }
        });

        return v;
    }
}*/