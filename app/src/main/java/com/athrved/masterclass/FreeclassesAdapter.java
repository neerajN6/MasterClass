package com.athrved.masterclass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FreeclassesAdapter extends RecyclerView.Adapter<FreeclassesAdapter.FreeViewHolder> {

    ArrayList<FreeHelperClass> featloc;

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
        holder.imagebig.setImageResource(freeHelperClass.getImagebig());
        holder.imagesmall1.setImageResource(freeHelperClass.getImagesmall1());
        holder.imagesmall2.setImageResource(freeHelperClass.getImagesmall2());
        holder.title.setText(freeHelperClass.getTitle());
        holder.topic.setText(freeHelperClass.getTopic());
        holder.author.setText(freeHelperClass.getAuthor());
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class FreeViewHolder extends RecyclerView.ViewHolder{
        ImageView imagebig, imagesmall1,imagesmall2;
        TextView title, topic, author;

        public FreeViewHolder(@NonNull View itemView){
            super(itemView);

            imagebig=itemView.findViewById(R.id.freeimgbig);
            imagesmall1=itemView.findViewById(R.id.freec1_image);
            imagesmall2=itemView.findViewById(R.id.freec2_image);

            title=itemView.findViewById(R.id.freec_title);
            topic=itemView.findViewById(R.id.freec_topic);
            author=itemView.findViewById(R.id.freec_author);


        }



    }


}