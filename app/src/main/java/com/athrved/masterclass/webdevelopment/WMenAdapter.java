package com.athrved.masterclass.webdevelopment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athrved.masterclass.R;

import java.util.ArrayList;

public class WMenAdapter extends RecyclerView.Adapter<WMenAdapter.WMenViewHolder> {

    ArrayList<WMenHelperClass> featloc;

    public WMenAdapter(ArrayList<WMenHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public WMenAdapter.WMenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.men_class_card_design,parent,false);
        WMenAdapter.WMenViewHolder wmenViewHolder = new WMenAdapter.WMenViewHolder(view);

        return wmenViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WMenAdapter.WMenViewHolder holder, int position) {
        WMenHelperClass wmenHelperClass = featloc.get(position);
        holder.wimage.setImageResource(wmenHelperClass.getWimage());
        holder.wname.setText(wmenHelperClass.getWname());
        holder.wdes.setText(wmenHelperClass.getWdes());
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class WMenViewHolder extends RecyclerView.ViewHolder{
        ImageView wimage;
        TextView wname,wdes;

        public WMenViewHolder(@NonNull View itemView){
            super(itemView);

            wimage = itemView.findViewById(R.id.men_image);
            wname = itemView.findViewById(R.id.mname);
            wdes = itemView.findViewById(R.id.des);
        }
    }
}