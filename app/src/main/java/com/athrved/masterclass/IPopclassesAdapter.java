package com.athrved.masterclass;
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

import java.util.ArrayList;
public class IPopclassesAdapter extends RecyclerView.Adapter<IPopclassesAdapter.IPopViewHolder> {

    ArrayList<IPopHelperClass> featloc;

    public IPopclassesAdapter(ArrayList<IPopHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public IPopclassesAdapter.IPopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pop_class_card_design,parent,false);
        IPopclassesAdapter.IPopViewHolder IPopViewHolder = new IPopclassesAdapter.IPopViewHolder(view);

        return IPopViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull IPopclassesAdapter.IPopViewHolder holder, int position) {
        IPopHelperClass IPopHelperClass = featloc.get(position);
        holder.iimagebig.setImageResource(IPopHelperClass.getIimagebig());
        holder.iimagesmall1.setImageResource(IPopHelperClass.getIimagesmall1());
        holder.iimagesmall2.setImageResource(IPopHelperClass.getIimagesmall2());
        holder.ititle.setText(IPopHelperClass.getItitle());
        holder.itopic.setText(IPopHelperClass.getItopic());
        holder.iauthor.setText(IPopHelperClass.getIauthor());
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class IPopViewHolder extends RecyclerView.ViewHolder{
        ImageView iimagebig, iimagesmall1,iimagesmall2;
        TextView ititle, itopic, iauthor;
        Button ibookmark_border, ibookmark;

        public IPopViewHolder(@NonNull final View itemView){
            super(itemView);

            iimagebig=itemView.findViewById(R.id.popimgbig);
            iimagesmall1=itemView.findViewById(R.id.popc1_image);
            iimagesmall2=itemView.findViewById(R.id.popc2_image);

            ibookmark=itemView.findViewById(R.id.bookmark);
            ibookmark_border=itemView.findViewById(R.id.bookmark_border);

            ititle=itemView.findViewById(R.id.popc_title);
            itopic=itemView.findViewById(R.id.popc_topic);
            iauthor=itemView.findViewById(R.id.popc_author);

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

