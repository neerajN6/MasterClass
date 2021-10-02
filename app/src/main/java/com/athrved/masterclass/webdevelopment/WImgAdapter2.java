package com.athrved.masterclass.webdevelopment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athrved.masterclass.R;

import java.util.List;

public class WImgAdapter2 extends RecyclerView.Adapter<WImgAdapter2.ViewHolder> {

    List<String> titles2;
    List<Integer> images2;
    LayoutInflater inflater2;
    public static int top;


    public WImgAdapter2(Context ctx2, List<String> titles2, List<Integer> images2){
        this.titles2 = titles2;
        this.images2 = images2;
        this.inflater2 = LayoutInflater.from(ctx2);
    }


    @NonNull
    @Override
    public WImgAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater2.inflate(R.layout.custom_grid_layout2,parent,false);
        return new WImgAdapter2.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WImgAdapter2.ViewHolder holder, int position) {
        holder.title2.setText(titles2.get(position));
        holder.gridIcon2.setImageResource(images2.get(position));
    }

    @Override
    public int getItemCount() {
        return titles2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title2;
        ImageView gridIcon2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title2 = itemView.findViewById(R.id.textView3);
            gridIcon2 = itemView.findViewById(R.id.imageView3);
            top = getAdapterPosition();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Clicked -> " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                   if(getAdapterPosition()==0){
                        Intent intent = new Intent(itemView.getContext(), WebTopicsActivity.class);
                        intent.putExtra("topic",String.valueOf(getAdapterPosition()));
                        intent.putExtra("course",String.valueOf(2));
                        itemView.getContext().startActivity(intent);
                    }
                    else if(getAdapterPosition()==1){
                        Intent intent = new Intent(itemView.getContext(), WebTopicsActivity.class);
                        intent.putExtra("topic",String.valueOf(getAdapterPosition()));
                        intent.putExtra("course",String.valueOf(2));
                        itemView.getContext().startActivity(intent);
                    }
                    else if(getAdapterPosition()==2){
                        Intent intent = new Intent(itemView.getContext(), WebTopicsActivity.class);
                        intent.putExtra("topic",String.valueOf(getAdapterPosition()));
                        intent.putExtra("course",String.valueOf(2));
                        itemView.getContext().startActivity(intent);
                    }
                    else if(getAdapterPosition()==3){
                        Intent intent = new Intent(itemView.getContext(), WebTopicsActivity.class);
                        intent.putExtra("topic",String.valueOf(getAdapterPosition()));
                        intent.putExtra("course",String.valueOf(2));
                        itemView.getContext().startActivity(intent);
                    }
                    else if(getAdapterPosition()==4){
                        Intent intent = new Intent(itemView.getContext(), WebTopicsActivity.class);
                        intent.putExtra("topic",String.valueOf(getAdapterPosition()));
                        intent.putExtra("course",String.valueOf(2));
                        itemView.getContext().startActivity(intent);
                    }
                    else if(getAdapterPosition()==5){
                        Intent intent = new Intent(itemView.getContext(), WebTopicsActivity.class);
                        intent.putExtra("topic",String.valueOf(getAdapterPosition()));
                        intent.putExtra("course",String.valueOf(2));
                        itemView.getContext().startActivity(intent);
                    }

                }
            });
        }
    }
}
