package com.athrved.masterclass.appdev;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athrved.masterclass.R;

import java.util.ArrayList;

public class AMenAdapter extends RecyclerView.Adapter<AMenAdapter.AMenViewHolder> {

    ArrayList<AMenHelperClass> featloc;

    public AMenAdapter(ArrayList<AMenHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public AMenAdapter.AMenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.men_class_card_design,parent,false);
        AMenAdapter.AMenViewHolder AMenViewHolder = new AMenAdapter.AMenViewHolder(view);

        return AMenViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AMenAdapter.AMenViewHolder holder, int position) {
        AMenHelperClass AMenHelperClass = featloc.get(position);
        holder.aimage.setImageResource(AMenHelperClass.getAimage());
        holder.aname.setText(AMenHelperClass.getAname());
        holder.ades.setText(AMenHelperClass.getAdes());
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class AMenViewHolder extends RecyclerView.ViewHolder{
        ImageView aimage;
        TextView aname,ades;

        public AMenViewHolder(@NonNull View itemView){
            super(itemView);

            aimage = itemView.findViewById(R.id.men_image);
            aname = itemView.findViewById(R.id.mname);
            ades = itemView.findViewById(R.id.des);
        }
    }
}
