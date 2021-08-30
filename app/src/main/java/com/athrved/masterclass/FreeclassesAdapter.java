package com.athrved.masterclass;

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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FreeclassesAdapter extends RecyclerView.Adapter<FreeclassesAdapter.FreeViewHolder> {

    ArrayList<FreeHelperClass> featloc;
    public static String a,b="FAILED TO LOAD";

    RequestQueue requestQueue;

    public FreeclassesAdapter(ArrayList<FreeHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public FreeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.free_class_card_design,parent,false);
        FreeViewHolder freeViewHolder = new FreeViewHolder(view);

        return freeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FreeViewHolder holder, int position) {
        FreeHelperClass freeHelperClass = featloc.get(position);

        holder.imagesmall1.setImageResource(freeHelperClass.getImagesmall1());
        holder.imagesmall2.setImageResource(freeHelperClass.getImagesmall2());
        holder.title.setText(freeHelperClass.getTitle());
        holder.topic.setText(freeHelperClass.getTopic());
        holder.author.setText(freeHelperClass.getAuthor());




        if(position==0){

            Picasso.get().load("https://img.youtube.com/vi/_vAmKNin0QM/maxresdefault.jpg").into(holder.imagebig);
        }
        if(position==1){

            Picasso.get().load("https://img.youtube.com/vi/lrcqt4RelJ4/maxresdefault.jpg").into(holder.imagebig);
        }
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class FreeViewHolder extends RecyclerView.ViewHolder{
        ImageView imagebig, imagesmall1,imagesmall2;
        TextView topic, author;
        TextView title;
        Button bookmark, bookmark_border;

        public FreeViewHolder(@NonNull final View itemView){
            super(itemView);

            imagebig=itemView.findViewById(R.id.freeimgbig);
            imagesmall1=itemView.findViewById(R.id.freec1_image);
            imagesmall2=itemView.findViewById(R.id.freec2_image);

            bookmark=itemView.findViewById(R.id.bookmarkfree);
            bookmark_border=itemView.findViewById(R.id.bookmarkfree_border);

            title=itemView.findViewById(R.id.freec_title);
            topic=itemView.findViewById(R.id.freec_topic);
            author=itemView.findViewById(R.id.freec_author);



            bookmark_border.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()==0){
                        bookmark_border.setVisibility(View.GONE);
                        bookmark.setVisibility(View.VISIBLE);
                    }
                    if(getAdapterPosition()==1){
                        bookmark_border.setVisibility(View.GONE);
                        bookmark.setVisibility(View.VISIBLE);
                    }
                }
            });

            bookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()==0){
                        bookmark_border.setVisibility(View.VISIBLE);
                        bookmark.setVisibility(View.GONE);
                    }
                    if(getAdapterPosition()==1){
                        bookmark_border.setVisibility(View.VISIBLE);
                        bookmark.setVisibility(View.GONE);
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