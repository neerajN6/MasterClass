package com.athrved.masterclass.appdev;

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

public class AFreeClassesAdapter extends RecyclerView.Adapter<AFreeClassesAdapter.AFreeViewHolder> {

    ArrayList<AFreeHelperClass> featloc;
    public static String a,b="FAILED TO LOAD";

    RequestQueue requestQueue;

    public AFreeClassesAdapter(ArrayList<AFreeHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public AFreeClassesAdapter.AFreeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.free_class_card_design,parent,false);
        AFreeClassesAdapter.AFreeViewHolder AFreeViewHolder = new AFreeClassesAdapter.AFreeViewHolder(view);

        return AFreeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AFreeClassesAdapter.AFreeViewHolder holder, int position) {
        AFreeHelperClass AFreeHelperClass = featloc.get(position);

        holder.aimagesmall1.setImageResource(AFreeHelperClass.getAimagesmall1());
        holder.aimagesmall2.setImageResource(AFreeHelperClass.getAimagesmall2());
        holder.atitle.setText(AFreeHelperClass.getAtitle());
        holder.atopic.setText(AFreeHelperClass.getAtopic());
        holder.aauthor.setText(AFreeHelperClass.getAauthor());

        if(position==0){

            Picasso.get().load("https://img.youtube.com/vi/_vAmKNin0QM/maxresdefault.jpg").into(holder.aimagebig);
        }
        if(position==1){

            Picasso.get().load("https://img.youtube.com/vi/lrcqt4RelJ4/maxresdefault.jpg").into(holder.aimagebig);
        }
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class AFreeViewHolder extends RecyclerView.ViewHolder{
        ImageView aimagebig, aimagesmall1,aimagesmall2;
        TextView atopic, aauthor;
        TextView atitle;
        Button abookmark, abookmark_border;

        public AFreeViewHolder(@NonNull final View itemView){
            super(itemView);

            aimagebig=itemView.findViewById(R.id.freeimgbig);
            aimagesmall1=itemView.findViewById(R.id.freec1_image);
            aimagesmall2=itemView.findViewById(R.id.freec2_image);

            abookmark=itemView.findViewById(R.id.bookmarkfree);
            abookmark_border=itemView.findViewById(R.id.bookmarkfree_border);

            atitle=itemView.findViewById(R.id.freec_title);
            atopic=itemView.findViewById(R.id.freec_topic);
            aauthor=itemView.findViewById(R.id.freec_author);



            abookmark_border.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()==0){
                        abookmark_border.setVisibility(View.GONE);
                        abookmark.setVisibility(View.VISIBLE);
                    }
                    if(getAdapterPosition()==1){
                        abookmark_border.setVisibility(View.GONE);
                        abookmark.setVisibility(View.VISIBLE);
                    }
                }
            });

            abookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()==0){
                        abookmark_border.setVisibility(View.VISIBLE);
                        abookmark.setVisibility(View.GONE);
                    }
                    if(getAdapterPosition()==1){
                        abookmark_border.setVisibility(View.VISIBLE);
                        abookmark.setVisibility(View.GONE);
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
