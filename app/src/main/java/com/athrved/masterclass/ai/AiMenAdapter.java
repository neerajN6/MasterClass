package com.athrved.masterclass.ai;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athrved.masterclass.R;

import java.util.ArrayList;

public class AiMenAdapter extends RecyclerView.Adapter<AiMenAdapter.AiMenViewHolder> {

    ArrayList<AiMenHelperClass> featloc;

    public AiMenAdapter(ArrayList<AiMenHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public AiMenAdapter.AiMenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.men_class_card_design,parent,false);
        AiMenAdapter.AiMenViewHolder aimenViewHolder = new AiMenAdapter.AiMenViewHolder(view);

        return aimenViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AiMenAdapter.AiMenViewHolder holder, int position) {
        AiMenHelperClass aimenHelperClass = featloc.get(position);
        holder.aiimage.setImageResource(aimenHelperClass.getAiimage());
        holder.ainame.setText(aimenHelperClass.getAiname());
        holder.aides.setText(aimenHelperClass.getAides());
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class AiMenViewHolder extends RecyclerView.ViewHolder{
        ImageView aiimage;
        TextView ainame,aides;

        public AiMenViewHolder(@NonNull View itemView){
            super(itemView);

            aiimage = itemView.findViewById(R.id.men_image);
            ainame = itemView.findViewById(R.id.mname);
            aides = itemView.findViewById(R.id.des);
        }
    }
}
