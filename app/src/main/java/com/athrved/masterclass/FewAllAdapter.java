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

public class FewAllAdapter extends RecyclerView.Adapter<FewAllAdapter.FewAllViewHolder> {

    ArrayList<FewAllHelperClass> featloc;

    public FewAllAdapter(ArrayList<FewAllHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public FewAllViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_all_classes,parent,false);
        FewAllViewHolder fewAllViewHolder = new FewAllViewHolder(view);

        return fewAllViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FewAllViewHolder holder, int position) {
        FewAllHelperClass fewAllHelperClass = featloc.get(position);
        holder.imagebig.setImageResource(fewAllHelperClass.getImageBig());
        holder.imagesmall.setImageResource(fewAllHelperClass.getImageSmall());
        holder.title.setText(fewAllHelperClass.getTitle());
        holder.topic.setText(fewAllHelperClass.getChannel());
        holder.author.setText(fewAllHelperClass.getAuthor());
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class FewAllViewHolder extends RecyclerView.ViewHolder{
        ImageView imagebig, imagesmall;
        TextView title, topic, author;
        Button bookmark, bookmark_border;

        public FewAllViewHolder(@NonNull final View itemView){
            super(itemView);

            imagebig=itemView.findViewById(R.id.add_course_image);
            imagesmall=itemView.findViewById(R.id.allc_image);

            title=itemView.findViewById(R.id.allc_title);
            topic=itemView.findViewById(R.id.allc_topic);
            author=itemView.findViewById(R.id.allc_author);



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

                    if (getAdapterPosition() == 2) {
                        Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
                        intent.putExtra("VIDEOID", "GhbuUctZiTg");
                        itemView.getContext().startActivity(intent);
                        Activity activity = (Activity) itemView.getContext();
                        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }

                }
            });

        }



    }


}
