package com.athrved.masterclass.machdesign;

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

import com.athrved.masterclass.PlayerActivity;
import com.athrved.masterclass.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MPopclassesAdapter extends RecyclerView.Adapter<MPopclassesAdapter.MPopViewHolder> {

    ArrayList<MPopHelperClass> featloc;
    public static String v_id1 = "_vAmKNin0QM";
    public static String v_id2 = "lrcqt4RelJ4";

    public MPopclassesAdapter(ArrayList<MPopHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public MPopclassesAdapter.MPopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pop_class_card_design, parent, false);
        MPopclassesAdapter.MPopViewHolder MPopViewHolder = new MPopclassesAdapter.MPopViewHolder(view);

        return MPopViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MPopclassesAdapter.MPopViewHolder holder, int position) {
        MPopHelperClass MPopHelperClass = featloc.get(position);
        holder.mimagebig.setImageResource(MPopHelperClass.getMimagebig());
        holder.mimagesmall1.setImageResource(MPopHelperClass.getMimagesmall1());
        holder.mimagesmall2.setImageResource(MPopHelperClass.getMimagesmall2());
        holder.mtitle.setText(MPopHelperClass.getMtitle());
        holder.mtopic.setText(MPopHelperClass.getMtopic());
        holder.mauthor.setText(MPopHelperClass.getMauthor());

        if (position == 0) {

            Picasso.get().load("https://img.youtube.com/vi/" + v_id1 + "/maxresdefault.jpg").into(holder.mimagebig);
        }
        if (position == 1) {

            Picasso.get().load("https://img.youtube.com/vi/" + v_id2 + "/maxresdefault.jpg").into(holder.mimagebig);
        }
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class MPopViewHolder extends RecyclerView.ViewHolder {
        ImageView mimagebig, mimagesmall1, mimagesmall2;
        TextView mtitle, mtopic, mauthor;
        Button mbookmark_border, mbookmark;

        public MPopViewHolder(@NonNull final View itemView) {
            super(itemView);

            mimagebig = itemView.findViewById(R.id.popimgbig);
            mimagesmall1 = itemView.findViewById(R.id.popc1_image);
            mimagesmall2 = itemView.findViewById(R.id.popc2_image);

            mbookmark = itemView.findViewById(R.id.bookmark);
            mbookmark_border = itemView.findViewById(R.id.bookmark_border);

            mtitle = itemView.findViewById(R.id.popc_title);
            mtopic = itemView.findViewById(R.id.popc_topic);
            mauthor = itemView.findViewById(R.id.popc_author);

            mbookmark_border.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 0) {
                        mbookmark_border.setVisibility(View.GONE);
                        mbookmark.setVisibility(View.VISIBLE);
                    }
                    if (getAdapterPosition() == 1) {
                        mbookmark_border.setVisibility(View.GONE);
                        mbookmark.setVisibility(View.VISIBLE);
                    }
                }
            });

            mbookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 0) {
                        mbookmark_border.setVisibility(View.VISIBLE);
                        mbookmark.setVisibility(View.GONE);
                    }
                    if (getAdapterPosition() == 1) {
                        mbookmark_border.setVisibility(View.VISIBLE);
                        mbookmark.setVisibility(View.GONE);
                    }
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 0) {
                        Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
                        intent.putExtra("VIDEOID", v_id1);
                        itemView.getContext().startActivity(intent);
                        Activity activity = (Activity) itemView.getContext();
                        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                    }

                    if (getAdapterPosition() == 1) {
                        Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
                        intent.putExtra("VIDEOID", v_id2);
                        itemView.getContext().startActivity(intent);
                        Activity activity = (Activity) itemView.getContext();
                        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }

                }
            });
        }

    }


}
