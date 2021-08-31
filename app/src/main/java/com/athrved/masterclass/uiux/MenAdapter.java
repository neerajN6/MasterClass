package com.athrved.masterclass.uiux;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athrved.masterclass.R;

import java.util.ArrayList;

public class MenAdapter extends RecyclerView.Adapter<MenAdapter.MenViewHolder> {

    ArrayList<MenHelperClass> featloc;

    public MenAdapter(ArrayList<MenHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public MenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.men_class_card_design,parent,false);
        MenViewHolder menViewHolder = new MenViewHolder(view);

        return menViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenViewHolder holder, int position) {
        MenHelperClass menHelperClass = featloc.get(position);
        holder.image.setImageResource(menHelperClass.getImage());
        holder.name.setText(menHelperClass.getName());
        holder.des.setText(menHelperClass.getDes());
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class MenViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name,des;

        public MenViewHolder(@NonNull View itemView){
            super(itemView);

            image = itemView.findViewById(R.id.men_image);
            name = itemView.findViewById(R.id.mname);
            des = itemView.findViewById(R.id.des);
        }
    }
}
