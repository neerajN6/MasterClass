package com.athrved.masterclass.ai;

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

import com.athrved.masterclass.MainActivity;
import com.athrved.masterclass.PlayerActivity;
import com.athrved.masterclass.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AiPopclassesAdapter extends RecyclerView.Adapter<AiPopclassesAdapter.AiPopViewHolder> {

    ArrayList<AiPopHelperClass> featloc;
    public static String v_id1 = "5RluSnRPRbI";
    public static String v_id2 = "lrcqt4RelJ4";

    public AiPopclassesAdapter(ArrayList<AiPopHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public AiPopclassesAdapter.AiPopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pop_class_card_design,parent,false);
        AiPopclassesAdapter.AiPopViewHolder aipopViewHolder = new AiPopclassesAdapter.AiPopViewHolder(view);

        return aipopViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AiPopclassesAdapter.AiPopViewHolder holder, int position) {
        AiPopHelperClass aipopHelperClass = featloc.get(position);
        holder.aiimagebig.setImageResource(aipopHelperClass.getAiimagebig());
        holder.aiimagesmall1.setImageResource(aipopHelperClass.getAiimagesmall1());
        holder.aiimagesmall2.setImageResource(aipopHelperClass.getAiimagesmall2());
        holder.aititle.setText(aipopHelperClass.getAititle());
        holder.aitopic.setText(aipopHelperClass.getAitopic());
        holder.aiauthor.setText(aipopHelperClass.getAiauthor());

        ArrayList<String> videoIds;
        ArrayList<String> vtitle;
        ArrayList<String> authorr;
        ArrayList<Integer> topic;
        ArrayList<Integer> course_id;
        ArrayList<Integer> paid;
        ArrayList<Integer> slno;

        ArrayList<String> webvv;

        videoIds = new ArrayList<>();
        course_id = new ArrayList<>();
        paid = new ArrayList<>();
        vtitle = new ArrayList<>();
        slno = new ArrayList<>();
        topic = new ArrayList<>();
        authorr = new ArrayList<>();

        MainActivity k = new MainActivity();
        k.getdatatotop();
        int jj=0;

        int pl=1;
        for (int kk=0;kk<k.videoIds.size();kk++) {
            if (k.course_id.get(kk) == pl-1)
                jj = kk + 1;


            if (position == 0) {
                holder.aititle.setText(k.vtitle.get(jj));
                Picasso.get().load("https://img.youtube.com/vi/" + k.videoIds.get(jj) + "/maxresdefault.jpg").into(holder.aiimagebig);
            }
            if (position == 1) {
                holder.aititle.setText(k.vtitle.get(jj + 1));
                Picasso.get().load("https://img.youtube.com/vi/" + k.videoIds.get(jj + 1) + "/maxresdefault.jpg").into(holder.aiimagebig);
            }

        }
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class AiPopViewHolder extends RecyclerView.ViewHolder{
        ImageView aiimagebig, aiimagesmall1,aiimagesmall2;
        TextView aititle, aitopic, aiauthor;
        Button aibookmark_border, aibookmark;

        public AiPopViewHolder(@NonNull final View itemView){
            super(itemView);

            aiimagebig=itemView.findViewById(R.id.popimgbig);
            aiimagesmall1=itemView.findViewById(R.id.popc1_image);
            aiimagesmall2=itemView.findViewById(R.id.popc2_image);

            aibookmark=itemView.findViewById(R.id.bookmark);
            aibookmark_border=itemView.findViewById(R.id.bookmark_border);

            aititle=itemView.findViewById(R.id.popc_title);
            aitopic=itemView.findViewById(R.id.popc_topic);
            aiauthor=itemView.findViewById(R.id.popc_author);

            aibookmark_border.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()==0){
                        aibookmark_border.setVisibility(View.GONE);
                        aibookmark.setVisibility(View.VISIBLE);
                    }
                    if(getAdapterPosition()==1){
                        aibookmark_border.setVisibility(View.GONE);
                        aibookmark.setVisibility(View.VISIBLE);
                    }
                }
            });

            aibookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()==0){
                        aibookmark_border.setVisibility(View.VISIBLE);
                        aibookmark.setVisibility(View.GONE);
                    }
                    if(getAdapterPosition()==1){
                        aibookmark_border.setVisibility(View.VISIBLE);
                        aibookmark.setVisibility(View.GONE);
                    }
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ArrayList<String> videoIds;
                    ArrayList<String> vtitle;
                    ArrayList<String> authorr;
                    ArrayList<Integer> topic;
                    ArrayList<Integer> course_id;
                    ArrayList<Integer> paid;
                    ArrayList<Integer> slno;

                    ArrayList<String> webvv;

                    videoIds = new ArrayList<>();
                    course_id = new ArrayList<>();
                    paid = new ArrayList<>();
                    vtitle = new ArrayList<>();
                    slno = new ArrayList<>();
                    topic = new ArrayList<>();
                    authorr = new ArrayList<>();

                    MainActivity k = new MainActivity();
                    k.getdatatotop();
                    int jj=0;

                    int pl=1;
                    for (int kk=0;kk<k.videoIds.size();kk++) {
                        if (k.course_id.get(kk) == pl - 1)
                            break;
                        jj = kk + 1;
                    }

                    if (getAdapterPosition() == 0) {
                        Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
                        intent.putExtra("VIDEOID", k.videoIds.get(jj));
                        itemView.getContext().startActivity(intent);
                        Activity activity = (Activity) itemView.getContext();
                        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                    }

                    if (getAdapterPosition() == 1) {
                        Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
                        intent.putExtra("VIDEOID", k.videoIds.get(jj+1));
                        itemView.getContext().startActivity(intent);
                        Activity activity = (Activity) itemView.getContext();
                        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }

                }
            });
        }

    }



}