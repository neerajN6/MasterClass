package com.athrved.masterclass.ai;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.athrved.masterclass.PlayerActivity;
import com.athrved.masterclass.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AiFreeClassesAdapter extends RecyclerView.Adapter<AiFreeClassesAdapter.AiFreeViewHolder> {

    ArrayList<AiFreeHelperClass> featloc;
    public static String a,b="FAILED TO LOAD";

    RequestQueue requestQueue;

    public AiFreeClassesAdapter(ArrayList<AiFreeHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public AiFreeClassesAdapter.AiFreeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.free_class_card_design,parent,false);
        AiFreeClassesAdapter.AiFreeViewHolder AifreeViewHolder = new AiFreeClassesAdapter.AiFreeViewHolder(view);

        return AifreeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AiFreeClassesAdapter.AiFreeViewHolder holder, int position) {
        AiFreeHelperClass AifreeHelperClass = featloc.get(position);

        holder.aiimagesmall1.setImageResource(AifreeHelperClass.getAiimagesmall1());
        holder.aiimagesmall2.setImageResource(AifreeHelperClass.getAiimagesmall2());
        holder.aititle.setText(AifreeHelperClass.getAititle());
        holder.aitopic.setText(AifreeHelperClass.getAitopic());
        holder.aiauthor.setText(AifreeHelperClass.getAiauthor());




        if(position==0){

            Picasso.get().load("https://img.youtube.com/vi/_vAmKNin0QM/maxresdefault.jpg").into(holder.aiimagebig);
        }
        if(position==1){

            Picasso.get().load("https://img.youtube.com/vi/lrcqt4RelJ4/maxresdefault.jpg").into(holder.aiimagebig);
        }
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class AiFreeViewHolder extends RecyclerView.ViewHolder{
        ImageView aiimagebig, aiimagesmall1,aiimagesmall2;
        TextView aitopic, aiauthor;
        TextView aititle;
        Button aibookmark, aibookmark_border;

        public AiFreeViewHolder(@NonNull final View itemView){
            super(itemView);

            aiimagebig=itemView.findViewById(R.id.freeimgbig);
            aiimagesmall1=itemView.findViewById(R.id.freec1_image);
            aiimagesmall2=itemView.findViewById(R.id.freec2_image);

            aibookmark=itemView.findViewById(R.id.bookmarkfree);
            aibookmark_border=itemView.findViewById(R.id.bookmarkfree_border);

            aititle=itemView.findViewById(R.id.freec_title);
            aitopic=itemView.findViewById(R.id.freec_topic);
            aiauthor=itemView.findViewById(R.id.freec_author);



            aibookmark_border.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()==0){
                        aibookmark_border.setVisibility(View.GONE);
                        aibookmark.setVisibility(View.VISIBLE);
                    }
                    if(getAdapterPosition()==1){
                        aibookmark_border.setVisibility(View.GONE);
                        aibookmark.setVisibility(View.VISIBLE);
                    }
                }
            });

            aibookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()==0){
                        aibookmark_border.setVisibility(View.VISIBLE);
                        aibookmark.setVisibility(View.GONE);
                    }
                    if(getAdapterPosition()==1){
                        aibookmark_border.setVisibility(View.VISIBLE);
                        aibookmark.setVisibility(View.GONE);
                    }
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 0) {
                        Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
                        intent.putExtra("VIDEOID", "_vAmKNin0QM");
                        itemView.getContext().startActivity(intent);
                        Activity activity = (Activity) itemView.getContext();
                        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                    }

                    if (getAdapterPosition() == 1) {
                        Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
                        intent.putExtra("VIDEOID", "lrcqt4RelJ4");
                        itemView.getContext().startActivity(intent);
                        Activity activity = (Activity) itemView.getContext();
                        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }

                }
            });

        }



    }


}