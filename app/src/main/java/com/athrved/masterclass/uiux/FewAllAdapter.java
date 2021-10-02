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

import com.athrved.masterclass.MainActivity;
import com.athrved.masterclass.PlayerActivity;
import com.athrved.masterclass.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FewAllAdapter extends RecyclerView.Adapter<FewAllAdapter.FewAllViewHolder> {

    ArrayList<FewAllHelperClass> featloc;
    public String v_id1;
    public String v_id2;
    public String v_id3;

    ArrayList<String> videoIds;
    ArrayList<String> vtitle;
    ArrayList<String> authorr;
    ArrayList<Integer> topic;
    ArrayList<Integer> course_id;
    ArrayList<Integer> paid;
    ArrayList<Integer> slno;

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
        holder.ttopic.setText(fewAllHelperClass.getChannel());
        holder.author.setText(fewAllHelperClass.getAuthor());

        videoIds = new ArrayList<>();
        course_id = new ArrayList<>();
        paid = new ArrayList<>();
        vtitle = new ArrayList<>();
        slno = new ArrayList<>();
        topic = new ArrayList<>();
        authorr = new ArrayList<>();
        ArrayList vnv = new ArrayList<>();
        MainActivity k =new MainActivity();
        k.getdatatotop();

        for (int i = 0; i < 3; i++) {
            for (int ki = 0; ki < k.videoIds.size(); ki++) {
                if (k.course_id.get(ki) == 5) {
                    vnv.add(k.videoIds.get(ki));

                    System.out.println("This is" + k.videoIds.get(ki));
                }
            }

                    if (position == i) {
                        Picasso.get().load("https://img.youtube.com/vi/" + vnv.get(i) + "/maxresdefault.jpg").into(holder.imagebig);
                    }


                }
    }

    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class FewAllViewHolder extends RecyclerView.ViewHolder{
        ImageView imagebig, imagesmall;
        TextView title, ttopic, author;
        Button bookmark, bookmark_border;

        public FewAllViewHolder(@NonNull final View itemView){
            super(itemView);

            imagebig=itemView.findViewById(R.id.add_course_image);
            imagesmall=itemView.findViewById(R.id.allc_image);

            title=itemView.findViewById(R.id.allc_title);
            ttopic=itemView.findViewById(R.id.allc_topic);
            author=itemView.findViewById(R.id.allc_author);



            itemView.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    ArrayList<String> videoIds;
                    ArrayList<String> vtitle;
                    ArrayList<String> authorr;
                    ArrayList<String> topic;
                    ArrayList<Integer> course_id;
                    ArrayList<Integer> paid;
                    ArrayList<Integer> slno;

                    MainActivity k =new MainActivity();
                    k.getdatatotop();
                    videoIds = new ArrayList<>();
                    course_id = new ArrayList<>();
                    paid = new ArrayList<>();
                    vtitle = new ArrayList<>();
                    topic = new ArrayList<>();
                    slno = new ArrayList<>();

                    authorr = new ArrayList<>();
                    if (getAdapterPosition() == 0) {
                        Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
                        intent.putExtra("VIDEOID", k.videoIds.get(getAdapterPosition()));
                        itemView.getContext().startActivity(intent);
                        Activity activity = (Activity) itemView.getContext();
                        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                    }

                    if (getAdapterPosition() == 1) {
                        Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
                        intent.putExtra("VIDEOID", k.videoIds.get(getAdapterPosition()));
                        itemView.getContext().startActivity(intent);
                        Activity activity = (Activity) itemView.getContext();
                        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }

                    if (getAdapterPosition() == 2) {
                        Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
                        intent.putExtra("VIDEOID", k.videoIds.get(getAdapterPosition()));
                        itemView.getContext().startActivity(intent);
                        Activity activity = (Activity) itemView.getContext();
                        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }

                }
            });

        }



    }


}
