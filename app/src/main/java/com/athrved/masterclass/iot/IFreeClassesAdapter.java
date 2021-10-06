package com.athrved.masterclass.iot;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.athrved.masterclass.PlayerActivity;
import com.athrved.masterclass.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class IFreeClassesAdapter extends RecyclerView.Adapter<IFreeClassesAdapter.IFreeViewHolder> {

    ArrayList<IFreeHelperClass> featloc;
    public static String a,b="FAILED TO LOAD";

    RequestQueue requestQueue;

    public IFreeClassesAdapter(ArrayList<IFreeHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public IFreeClassesAdapter.IFreeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.free_class_card_design,parent,false);
        IFreeClassesAdapter.IFreeViewHolder IFreeViewHolder = new IFreeClassesAdapter.IFreeViewHolder(view);

        return IFreeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull IFreeClassesAdapter.IFreeViewHolder holder, int position) {
        IFreeHelperClass IFreeHelperClass = featloc.get(position);

        holder.iimagesmall1.setImageResource(IFreeHelperClass.getIimagesmall1());
        holder.iimagesmall2.setImageResource(IFreeHelperClass.getIimagesmall2());
        holder.ititle.setText(IFreeHelperClass.getItitle());
        holder.itopic.setText(IFreeHelperClass.getItopic());
        holder.iauthor.setText(IFreeHelperClass.getIauthor());




        if(position==0){

            Picasso.get().load("https://img.youtube.com/vi/_vAmKNin0QM/maxresdefault.jpg").into(holder.iimagebig);
        }
        if(position==1){

            Picasso.get().load("https://img.youtube.com/vi/lrcqt4RelJ4/maxresdefault.jpg").into(holder.iimagebig);
        }
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class IFreeViewHolder extends RecyclerView.ViewHolder{
        ImageView iimagebig, iimagesmall1,iimagesmall2;
        TextView itopic, iauthor;
        TextView ititle;
        Button ibookmark, ibookmark_border;

        public IFreeViewHolder(@NonNull final View itemView){
            super(itemView);

            iimagebig=itemView.findViewById(R.id.freeimgbig);
            iimagesmall1=itemView.findViewById(R.id.freec1_image);
            iimagesmall2=itemView.findViewById(R.id.freec2_image);

            ibookmark=itemView.findViewById(R.id.bookmarkfree);
            ibookmark_border=itemView.findViewById(R.id.bookmarkfree_border);

            ititle=itemView.findViewById(R.id.freec_title);
            itopic=itemView.findViewById(R.id.freec_topic);
            iauthor=itemView.findViewById(R.id.freec_author);



            ibookmark_border.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()==0){
                        ibookmark_border.setVisibility(View.GONE);
                        ibookmark.setVisibility(View.VISIBLE);
                    }
                    if(getAdapterPosition()==1){
                        ibookmark_border.setVisibility(View.GONE);
                        ibookmark.setVisibility(View.VISIBLE);
                    }
                }
            });

            ibookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()==0){
                        ibookmark_border.setVisibility(View.VISIBLE);
                        ibookmark.setVisibility(View.GONE);
                    }
                    if(getAdapterPosition()==1){
                        ibookmark_border.setVisibility(View.VISIBLE);
                        ibookmark.setVisibility(View.GONE);
                    }
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 0) {
                        Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
                        intent.putExtra("VIDEOID", "_vAmKNin0QM");
                        itemView.getContext().startActivity(intent);
                        Activity activity = (Activity) itemView.getContext();
                        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                    }

                    if (getAdapterPosition() == 1) {
                        Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
                        intent.putExtra("VIDEOID", "lrcqt4RelJ4");
                        itemView.getContext().startActivity(intent);
                        Activity activity = (Activity) itemView.getContext();
                        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }

                }
            });

        }



    }


}
