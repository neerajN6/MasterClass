package com.athrved.masterclass.uiux;

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

public class PopclassesAdapter extends RecyclerView.Adapter<PopclassesAdapter.PopViewHolder> {

    ArrayList<PopHelperClass> featloc;
    public static String v_id1 = "_vAmKNin0QM";
    public static String v_id2 = "lrcqt4RelJ4";

    public PopclassesAdapter(ArrayList<PopHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public PopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pop_class_card_design, parent, false);
        PopViewHolder popViewHolder = new PopViewHolder(view);

        return popViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PopViewHolder holder, int position) {
        PopHelperClass popHelperClass = featloc.get(position);
        holder.imagebig.setImageResource(popHelperClass.getImagebig());
        holder.imagesmall1.setImageResource(popHelperClass.getImagesmall1());
        holder.imagesmall2.setImageResource(popHelperClass.getImagesmall2());
        holder.title.setText(popHelperClass.getTitle());
        holder.topic.setText(popHelperClass.getTopic());
        holder.author.setText(popHelperClass.getAuthor());

        if (position == 0) {

            Picasso.get().load("https://img.youtube.com/vi/" + v_id1 + "/maxresdefault.jpg").into(holder.imagebig);
        }
        if (position == 1) {

            Picasso.get().load("https://img.youtube.com/vi/" + v_id2 + "/maxresdefault.jpg").into(holder.imagebig);
        }
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class PopViewHolder extends RecyclerView.ViewHolder {
        ImageView imagebig, imagesmall1, imagesmall2;
        TextView title, topic, author;
        Button bookmark_border, bookmark;

        public PopViewHolder(@NonNull final View itemView) {
            super(itemView);

            imagebig = itemView.findViewById(R.id.popimgbig);
            imagesmall1 = itemView.findViewById(R.id.popc1_image);
            imagesmall2 = itemView.findViewById(R.id.popc2_image);

            bookmark = itemView.findViewById(R.id.bookmark);
            bookmark_border = itemView.findViewById(R.id.bookmark_border);

            title = itemView.findViewById(R.id.popc_title);
            topic = itemView.findViewById(R.id.popc_topic);
            author = itemView.findViewById(R.id.popc_author);

            bookmark_border.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 0) {
                        bookmark_border.setVisibility(View.GONE);
                        bookmark.setVisibility(View.VISIBLE);
                    }
                    if (getAdapterPosition() == 1) {
                        bookmark_border.setVisibility(View.GONE);
                        bookmark.setVisibility(View.VISIBLE);
                    }
                }
            });

            bookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 0) {
                        bookmark_border.setVisibility(View.VISIBLE);
                        bookmark.setVisibility(View.GONE);
                    }
                    if (getAdapterPosition() == 1) {
                        bookmark_border.setVisibility(View.VISIBLE);
                        bookmark.setVisibility(View.GONE);
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



