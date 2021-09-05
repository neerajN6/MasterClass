package com.athrved.masterclass.machdesign;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.athrved.masterclass.R;

import java.util.ArrayList;

public class MMenAdapter extends RecyclerView.Adapter<MMenAdapter.MMenViewHolder> {

    ArrayList<MMenHelperClass> featloc;

    public MMenAdapter(ArrayList<MMenHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public MMenAdapter.MMenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.men_class_card_design,parent,false);
        MMenAdapter.MMenViewHolder MMenViewHolder = new MMenAdapter.MMenViewHolder(view);

        return MMenViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MMenAdapter.MMenViewHolder holder, int position) {
        MMenHelperClass MMenHelperClass = featloc.get(position);
        holder.mimage.setImageResource(MMenHelperClass.getMimage());
        holder.mname.setText(MMenHelperClass.getMname());
        holder.mdes.setText(MMenHelperClass.getMdes());
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class MMenViewHolder extends RecyclerView.ViewHolder{
        ImageView mimage;
        TextView mname,mdes;

        public MMenViewHolder(@NonNull View itemView){
            super(itemView);

            mimage = itemView.findViewById(R.id.men_image);
            mname = itemView.findViewById(R.id.mname);
            mdes = itemView.findViewById(R.id.des);
        }
    }
}

