package com.athrved.masterclass.webdevelopment;

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

public class WFreeClassesAdapter extends RecyclerView.Adapter<WFreeClassesAdapter.WFreeViewHolder> {

    ArrayList<WFreeHelperClass> featloc;
    public static String a,b="FAILED TO LOAD";

    RequestQueue requestQueue;

    public WFreeClassesAdapter(ArrayList<WFreeHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public WFreeClassesAdapter.WFreeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.free_class_card_design,parent,false);
        WFreeClassesAdapter.WFreeViewHolder WfreeViewHolder = new WFreeClassesAdapter.WFreeViewHolder(view);

        return WfreeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WFreeClassesAdapter.WFreeViewHolder holder, int position) {
        WFreeHelperClass WfreeHelperClass = featloc.get(position);

        holder.wimagesmall1.setImageResource(WfreeHelperClass.getWimagesmall1());
        holder.wimagesmall2.setImageResource(WfreeHelperClass.getWimagesmall2());
        holder.wtitle.setText(WfreeHelperClass.getWtitle());
        holder.wtopic.setText(WfreeHelperClass.getWtopic());
        holder.wauthor.setText(WfreeHelperClass.getWauthor());




        if(position==0){

            Picasso.get().load("https://img.youtube.com/vi/_vAmKNin0QM/maxresdefault.jpg").into(holder.wimagebig);
        }
        if(position==1){

            Picasso.get().load("https://img.youtube.com/vi/lrcqt4RelJ4/maxresdefault.jpg").into(holder.wimagebig);
        }
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class WFreeViewHolder extends RecyclerView.ViewHolder{
        ImageView wimagebig, wimagesmall1,wimagesmall2;
        TextView wtopic, wauthor;
        TextView wtitle;
        Button wbookmark, wbookmark_border;

        public WFreeViewHolder(@NonNull final View itemView){
            super(itemView);

            wimagebig=itemView.findViewById(R.id.freeimgbig);
            wimagesmall1=itemView.findViewById(R.id.freec1_image);
            wimagesmall2=itemView.findViewById(R.id.freec2_image);

            wbookmark=itemView.findViewById(R.id.bookmarkfree);
            wbookmark_border=itemView.findViewById(R.id.bookmarkfree_border);

            wtitle=itemView.findViewById(R.id.freec_title);
            wtopic=itemView.findViewById(R.id.freec_topic);
            wauthor=itemView.findViewById(R.id.freec_author);



            wbookmark_border.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()==0){
                        wbookmark_border.setVisibility(View.GONE);
                        wbookmark.setVisibility(View.VISIBLE);
                    }
                    if(getAdapterPosition()==1){
                        wbookmark_border.setVisibility(View.GONE);
                        wbookmark.setVisibility(View.VISIBLE);
                    }
                }
            });

            wbookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()==0){
                        wbookmark_border.setVisibility(View.VISIBLE);
                        wbookmark.setVisibility(View.GONE);
                    }
                    if(getAdapterPosition()==1){
                        wbookmark_border.setVisibility(View.VISIBLE);
                        wbookmark.setVisibility(View.GONE);
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