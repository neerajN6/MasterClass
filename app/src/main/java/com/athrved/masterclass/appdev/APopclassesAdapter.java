package com.athrved.masterclass.appdev;

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

public class APopclassesAdapter extends RecyclerView.Adapter<APopclassesAdapter.APopViewHolder> {

    ArrayList<APopHelperClass> featloc;
    public static String v_id1 = "_vAmKNin0QM";
    public static String v_id2 = "lrcqt4RelJ4";

    public APopclassesAdapter(ArrayList<APopHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public APopclassesAdapter.APopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pop_class_card_design, parent, false);
        APopclassesAdapter.APopViewHolder APopViewHolder = new APopclassesAdapter.APopViewHolder(view);

        return APopViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull APopclassesAdapter.APopViewHolder holder, int position) {
        APopHelperClass APopHelperClass = featloc.get(position);
        holder.aimagebig.setImageResource(APopHelperClass.getAimagebig());
        holder.aimagesmall1.setImageResource(APopHelperClass.getAimagesmall1());
        holder.aimagesmall2.setImageResource(APopHelperClass.getAimagesmall2());
        holder.atitle.setText(APopHelperClass.getAtitle());
        holder.atopic.setText(APopHelperClass.getAtopic());
        holder.aauthor.setText(APopHelperClass.getAauthor());

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

        int pl=3;
        for (int kk=0;kk<k.videoIds.size();kk++) {
            if (k.course_id.get(kk) == pl)
                break;
            jj = kk + 1;
        }

            if (position == 0) {
                holder.atitle.setText(k.vtitle.get(jj));
                Picasso.get().load("https://img.youtube.com/vi/" + k.videoIds.get(jj) + "/maxresdefault.jpg").into(holder.aimagebig);
            }
            if (position == 1) {
                holder.atitle.setText(k.vtitle.get(jj + 1));
                Picasso.get().load("https://img.youtube.com/vi/" + k.videoIds.get(jj + 1) + "/maxresdefault.jpg").into(holder.aimagebig);
            }

        }
    

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class APopViewHolder extends RecyclerView.ViewHolder {
        ImageView aimagebig, aimagesmall1, aimagesmall2;
        TextView atitle, atopic, aauthor;
        Button abookmark_border, abookmark;

        public APopViewHolder(@NonNull final View itemView) {
            super(itemView);

            aimagebig = itemView.findViewById(R.id.popimgbig);
            aimagesmall1 = itemView.findViewById(R.id.popc1_image);
            aimagesmall2 = itemView.findViewById(R.id.popc2_image);

            abookmark = itemView.findViewById(R.id.bookmark);
            abookmark_border = itemView.findViewById(R.id.bookmark_border);

            atitle = itemView.findViewById(R.id.popc_title);
            atopic = itemView.findViewById(R.id.popc_topic);
            aauthor = itemView.findViewById(R.id.popc_author);

            abookmark_border.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 0) {
                        abookmark_border.setVisibility(View.GONE);
                        abookmark.setVisibility(View.VISIBLE);
                    }
                    if (getAdapterPosition() == 1) {
                        abookmark_border.setVisibility(View.GONE);
                        abookmark.setVisibility(View.VISIBLE);
                    }
                }
            });

            abookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 0) {
                        abookmark_border.setVisibility(View.VISIBLE);
                        abookmark.setVisibility(View.GONE);
                    }
                    if (getAdapterPosition() == 1) {
                        abookmark_border.setVisibility(View.VISIBLE);
                        abookmark.setVisibility(View.GONE);
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

                    int pl=3;
                    for (int kk=0;kk<k.videoIds.size();kk++) {
                        if (k.course_id.get(kk) == pl)
                            break;
                        jj = kk + 1;
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
