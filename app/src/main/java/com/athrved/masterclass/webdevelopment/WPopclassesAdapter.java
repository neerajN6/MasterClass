package com.athrved.masterclass.webdevelopment;

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

public class WPopclassesAdapter extends RecyclerView.Adapter<WPopclassesAdapter.WPopViewHolder> {

    ArrayList<WPopHelperClass> featloc;
    public static String v_id1 = "_vAmKNin0QM";
    public static String v_id2 = "lrcqt4RelJ4";

    public WPopclassesAdapter(ArrayList<WPopHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public WPopclassesAdapter.WPopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pop_class_card_design, parent, false);
        WPopclassesAdapter.WPopViewHolder wpopViewHolder = new WPopclassesAdapter.WPopViewHolder(view);

        return wpopViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WPopclassesAdapter.WPopViewHolder holder, int position) {
        WPopHelperClass wpopHelperClass = featloc.get(position);
        holder.wimagebig.setImageResource(wpopHelperClass.getWimagebig());
        holder.wimagesmall1.setImageResource(wpopHelperClass.getWimagesmall1());
        holder.wimagesmall2.setImageResource(wpopHelperClass.getWimagesmall2());
        holder.wtitle.setText(wpopHelperClass.getWtitle());
        holder.wtopic.setText(wpopHelperClass.getWtopic());
        holder.wauthor.setText(wpopHelperClass.getWauthor());

        if (position == 0) {

            Picasso.get().load("https://img.youtube.com/vi/" + v_id1 + "/maxresdefault.jpg").into(holder.wimagebig);
        }
        if (position == 1) {

            Picasso.get().load("https://img.youtube.com/vi/" + v_id2 + "/maxresdefault.jpg").into(holder.wimagebig);
        }
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class WPopViewHolder extends RecyclerView.ViewHolder {
        ImageView wimagebig, wimagesmall1, wimagesmall2;
        TextView wtitle, wtopic, wauthor;
        Button wbookmark_border, wbookmark;

        public WPopViewHolder(@NonNull final View itemView) {
            super(itemView);

            wimagebig = itemView.findViewById(R.id.popimgbig);
            wimagesmall1 = itemView.findViewById(R.id.popc1_image);
            wimagesmall2 = itemView.findViewById(R.id.popc2_image);

            wbookmark = itemView.findViewById(R.id.bookmark);
            wbookmark_border = itemView.findViewById(R.id.bookmark_border);

            wtitle = itemView.findViewById(R.id.popc_title);
            wtopic = itemView.findViewById(R.id.popc_topic);
            wauthor = itemView.findViewById(R.id.popc_author);

            wbookmark_border.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 0) {
                        wbookmark_border.setVisibility(View.GONE);
                        wbookmark.setVisibility(View.VISIBLE);
                    }
                    if (getAdapterPosition() == 1) {
                        wbookmark_border.setVisibility(View.GONE);
                        wbookmark.setVisibility(View.VISIBLE);
                    }
                }
            });

            wbookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 0) {
                        wbookmark_border.setVisibility(View.VISIBLE);
                        wbookmark.setVisibility(View.GONE);
                    }
                    if (getAdapterPosition() == 1) {
                        wbookmark_border.setVisibility(View.VISIBLE);
                        wbookmark.setVisibility(View.GONE);
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