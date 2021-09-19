package com.athrved.masterclass;

import android.app.Activity;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athrved.masterclass.uiux.PopHelperClass;
import com.athrved.masterclass.uiux.PopclassesAdapter;

import java.util.ArrayList;

public class FoundclassesAdapter extends RecyclerView.Adapter<FoundclassesAdapter.FoundViewHolder> {

    ArrayList<FoundHelperClass> featloc;

    public FoundclassesAdapter(ArrayList<FoundHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public FoundViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_str_card_design,parent,false);
        FoundViewHolder FoundViewHolder = new FoundViewHolder(view);

        return FoundViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoundViewHolder holder, int position) {
        FoundHelperClass FoundHelperClass = featloc.get(position);
        holder.fimage.setImageResource(FoundHelperClass.getFimage());
        holder.ftitle.setText(FoundHelperClass.getFtitle());
        holder.fdesc.setText(FoundHelperClass.getFdesc());
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class FoundViewHolder extends RecyclerView.ViewHolder{
        ImageView fimage;
        TextView ftitle, fdesc;
        LinearLayout fbookmark_border, fbookmark;

        public FoundViewHolder(@NonNull final View itemView){
            super(itemView);

            fimage=itemView.findViewById(R.id.fffimage);
            ftitle=itemView.findViewById(R.id.ffftitle);
            fdesc=itemView.findViewById(R.id.fffdesc);

            fbookmark=itemView.findViewById(R.id.save_layout);
            fbookmark_border=itemView.findViewById(R.id.saved_layout);


            fbookmark_border.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()==0){
                        fbookmark_border.setVisibility(View.GONE);
                        fbookmark.setVisibility(View.VISIBLE);
                    }
                    if(getAdapterPosition()==1){
                        fbookmark_border.setVisibility(View.GONE);
                        fbookmark.setVisibility(View.VISIBLE);
                    }
                }
            });

            fbookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()==0){
                        fbookmark_border.setVisibility(View.VISIBLE);
                        fbookmark.setVisibility(View.GONE);
                    }
                    if(getAdapterPosition()==1){
                        fbookmark_border.setVisibility(View.VISIBLE);
                        fbookmark.setVisibility(View.GONE);
                    }
                }
            });

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (getAdapterPosition() == 0) {
//                        Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
//                        intent.putExtra("VIDEOID", "_vAmKNin0QM");
//                        itemView.getContext().startActivity(intent);
//                        Activity activity = (Activity) itemView.getContext();
//                        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//
//                    }
//
//                    if (getAdapterPosition() == 1) {
//                        Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
//                        intent.putExtra("VIDEOID", "lrcqt4RelJ4");
//                        itemView.getContext().startActivity(intent);
//                        Activity activity = (Activity) itemView.getContext();
//                        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//                    }
//
//                }
//            });
        }

    }



}
