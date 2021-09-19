package com.athrved.masterclass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athrved.masterclass.R;

import java.util.ArrayList;

public class IMenAdapter extends RecyclerView.Adapter<IMenAdapter.IMenViewHolder> {

    ArrayList<IMenHelperClass> featloc;

    public IMenAdapter(ArrayList<IMenHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public IMenAdapter.IMenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.men_class_card_design,parent,false);
        IMenAdapter.IMenViewHolder IMenViewHolder = new IMenAdapter.IMenViewHolder(view);

        return IMenViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull IMenAdapter.IMenViewHolder holder, int position) {
        IMenHelperClass IMenHelperClass = featloc.get(position);
        holder.iimage.setImageResource(IMenHelperClass.getIimage());
        holder.iname.setText(IMenHelperClass.getIname());
        holder.ides.setText(IMenHelperClass.getIdes());
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class IMenViewHolder extends RecyclerView.ViewHolder{
        ImageView iimage;
        TextView iname,ides;

        public IMenViewHolder(@NonNull View itemView){
            super(itemView);

            iimage = itemView.findViewById(R.id.men_image);
            iname = itemView.findViewById(R.id.mname);
            ides = itemView.findViewById(R.id.des);
        }
    }
}
