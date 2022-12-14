package com.athrved.masterclass.machdesign;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.android.volley.RequestQueue;
import com.athrved.masterclass.MainActivity;
import com.athrved.masterclass.PlayerActivity;
import com.athrved.masterclass.R;
import com.squareup.picasso.Picasso;

public class MFreeClassesAdapter extends RecyclerView.Adapter<MFreeClassesAdapter.MFreeViewHolder> {

    ArrayList<MFreeHelperClass> featloc;
    public static String a, b = "FAILED TO LOAD";
    public static String v_id1 = "_vAmKNin0QM";
    public static String v_id2 = "lrcqt4RelJ4";

    RequestQueue requestQueue;

    public MFreeClassesAdapter(ArrayList<MFreeHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public MFreeClassesAdapter.MFreeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.free_class_card_design, parent, false);
        MFreeClassesAdapter.MFreeViewHolder mFreeViewHolder = new MFreeClassesAdapter.MFreeViewHolder(view);

        return mFreeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MFreeClassesAdapter.MFreeViewHolder holder, int position) {
        MFreeHelperClass MFreeHelperClass = featloc.get(position);

        holder.mimagesmall1.setImageResource(MFreeHelperClass.getMimagesmall1());
        holder.mimagesmall2.setImageResource(MFreeHelperClass.getMimagesmall2());
        holder.mtitle.setText(MFreeHelperClass.getMtitle());
        holder.mtopic.setText(MFreeHelperClass.getMtopic());
        holder.mauthor.setText(MFreeHelperClass.getMauthor());


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

        int pl=4;
        for (int kk=0;kk<k.videoIds.size();kk++) {
            if (k.course_id.get(kk) == pl)
                break;
            jj = kk + 3;
        }

            if (position == 0) {
                holder.mtitle.setText(k.vtitle.get(jj));
                Picasso.get().load("https://img.youtube.com/vi/" + k.videoIds.get(jj) + "/maxresdefault.jpg").into(holder.mimagebig);
            }
            if (position == 1) {
                holder.mtitle.setText(k.vtitle.get(jj + 1));
                Picasso.get().load("https://img.youtube.com/vi/" + k.videoIds.get(jj + 1) + "/maxresdefault.jpg").into(holder.mimagebig);
            }


    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class MFreeViewHolder extends RecyclerView.ViewHolder {
        ImageView mimagebig, mimagesmall1, mimagesmall2;
        TextView mtopic, mauthor;
        TextView mtitle;
        Button mbookmark, mbookmark_border;

        public MFreeViewHolder(@NonNull final View itemView) {
            super(itemView);

            mimagebig = itemView.findViewById(R.id.freeimgbig);
            mimagesmall1 = itemView.findViewById(R.id.freec1_image);
            mimagesmall2 = itemView.findViewById(R.id.freec2_image);

            mbookmark = itemView.findViewById(R.id.bookmarkfree);
            mbookmark_border = itemView.findViewById(R.id.bookmarkfree_border);

            mtitle = itemView.findViewById(R.id.freec_title);
            mtopic = itemView.findViewById(R.id.freec_topic);
            mauthor = itemView.findViewById(R.id.freec_author);


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

                    int pl=4;
                    for (int kk=0;kk<k.videoIds.size();kk++) {
                        if (k.course_id.get(kk) == pl)
                            break;
                        jj = kk + 3;
                    }
                    if (getAdapterPosition() == 0) {
                        Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
                        intent.putExtra("VIDEOID", k.videoIds.get(jj));
                        intent.putExtra("VTITLE",k.vtitle.get(jj));

                        itemView.getContext().startActivity(intent);
                        Activity activity = (Activity) itemView.getContext();
                        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                    }

                    if (getAdapterPosition() == 1) {
                        Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
                        intent.putExtra("VIDEOID", k.videoIds.get(jj+1));
                        intent.putExtra("VTITLE",k.vtitle.get(jj+1));
                        itemView.getContext().startActivity(intent);
                        Activity activity = (Activity) itemView.getContext();
                        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }

                }
            });

        }
    }
}