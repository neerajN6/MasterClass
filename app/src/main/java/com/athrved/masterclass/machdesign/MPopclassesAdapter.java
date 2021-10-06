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

import com.athrved.masterclass.MainActivity;
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

        int pl=4; //4 FOR MACH, 1 FOR AI . . .
        for (int kk=0;kk<k.videoIds.size();kk++) {
            if (k.course_id.get(kk) == pl-1)
                jj = kk + 1;


            if (position == 0) {
                holder.mtitle.setText(k.vtitle.get(jj));
                Picasso.get().load("https://img.youtube.com/vi/" + k.videoIds.get(jj) + "/maxresdefault.jpg").into(holder.mimagebig);
            }
            if (position == 1) {
                holder.mtitle.setText(k.vtitle.get(jj + 1));
                Picasso.get().load("https://img.youtube.com/vi/" + k.videoIds.get(jj + 1) + "/maxresdefault.jpg").into(holder.mimagebig);
            }

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
