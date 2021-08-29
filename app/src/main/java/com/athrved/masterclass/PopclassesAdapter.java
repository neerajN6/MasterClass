package com.athrved.masterclass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PopclassesAdapter extends RecyclerView.Adapter<PopclassesAdapter.PopViewHolder> {

    ArrayList<PopHelperClass> featloc;

    public PopclassesAdapter(ArrayList<PopHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public PopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pop_class_card_design,parent,false);
        PopViewHolder popViewHolder = new PopViewHolder(view);

        return popViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PopViewHolder holder, int position) {
        PopHelperClass popHelperClass = featloc.get(position);
        holder.imagebig.setImageResource(popHelperClass.getImagebig());
        holder.imagesmall1.setImageResource(popHelperClass.getImagesmall1());
        holder.imagesmall2.setImageResource(popHelperClass.getImagesmall2());
        holder.title.setText(popHelperClass.getTitle());
        holder.topic.setText(popHelperClass.getTopic());
        holder.author.setText(popHelperClass.getAuthor());
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class PopViewHolder extends RecyclerView.ViewHolder{
        ImageView imagebig, imagesmall1,imagesmall2;
        TextView title, topic, author;

        public PopViewHolder(@NonNull View itemView){
            super(itemView);

            imagebig=itemView.findViewById(R.id.popimgbig);
            imagesmall1=itemView.findViewById(R.id.popc1_image);
            imagesmall2=itemView.findViewById(R.id.popc2_image);

            title=itemView.findViewById(R.id.popc_title);
            topic=itemView.findViewById(R.id.popc_topic);
            author=itemView.findViewById(R.id.popc_author);

        }



    }


}