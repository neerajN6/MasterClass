package com.athrved.masterclass.webdevelopment;
import androidx.annotation.NonNull;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.athrved.masterclass.MainActivity;
import com.athrved.masterclass.PlayerActivity;
import com.athrved.masterclass.R;
import com.athrved.masterclass.VideoData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class WebTopicAdapter extends RecyclerView.Adapter<WebTopicAdapter.WebTopicViewHolder> {

    VideoData vv;

    ArrayList<WebTopicHelperClass> featloc;

    public WebTopicAdapter(ArrayList<WebTopicHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull
    @Override
    public WebTopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_all_classes, parent, false);
        WebTopicViewHolder WebTopicViewHolder = new WebTopicViewHolder(view);


        return WebTopicViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WebTopicViewHolder holder, int position) {
        WebTopicHelperClass WebTopicHelperClass = featloc.get(position);
        holder.ffimagebig.setImageResource(WebTopicHelperClass.getWtimagebig());
        holder.ffimagesmall.setImageResource(WebTopicHelperClass.getWtimagesmall());
        holder.fftitle.setText(WebTopicHelperClass.getWttitle());
        holder.fftopic.setText(WebTopicHelperClass.getWtopicname());
        holder.ffauthor.setText(WebTopicHelperClass.getWtauthor());

        MainActivity k = new MainActivity();
        k.getdatatotop();
        WebActivity g = new WebActivity();
        int gh = g.callla;
        WebTopicsActivity ta = new WebTopicsActivity();

        ArrayList vnv = new ArrayList<>();
        int ll = WImgAdapter2.webtop;

        int count1 = 0;
        int countw = 0;

        for (int pk = 0; pk < k.videoIds.size(); pk++)
            if (k.course_id.get(pk) == 2 && k.topic.get(pk) == ll)
                count1++;



        int jj = holder.getAdapterPosition();


            for (int i = 0; i < count1; i++) {
                if (holder.getAdapterPosition() == i) {

                    for (int ki = 0; ki < k.videoIds.size(); ki++) {
                        if (k.course_id.get(ki) == 2 && k.topic.get(ki) == ll) {
                            vnv.add(k.videoIds.get(ki));
                            System.out.println("This is" + k.videoIds.get(ki));
                        }
                    }


                    Picasso.get().load("https://img.youtube.com/vi/" + vnv.get(i) + "/maxresdefault.jpg").into(holder.ffimagebig);
                }
            }


//
//        int count2 = 0;
//        vnv.clear();
//        for (int pk = 0; pk < k.videoIds.size(); pk++)
//            if (k.course_id.get(pk) == 2)
//                count2++;
//
//        if (getItemCount() == count2) {
//
//
////            int jj = holder.getAdapterPosition();
//
//
//            for (int i = 0; i < count2; i++) {
//                if (holder.getAdapterPosition() == i) {
//
//                    for (int ki = 0; ki < k.videoIds.size(); ki++) {
//                        if (k.course_id.get(ki) == 2) {
//                            vnv.add(k.videoIds.get(ki));
//                            System.out.println("This is" + k.videoIds.get(ki));
//                        }
//                    }
//
//
//                    Picasso.get().load("https://img.youtube.com/vi/" + vnv.get(i) + "/maxresdefault.jpg").into(holder.ffimagebig);
//                }
//            }
//        }
    }









    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class WebTopicViewHolder extends RecyclerView.ViewHolder{
        ImageView ffimagebig, ffimagesmall;
        TextView fftitle, fftopic, ffauthor;
        Button bookmark, bookmark_border;

        public WebTopicViewHolder(@NonNull final View itemView){
            super(itemView);


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

            webvv = new ArrayList<>();

            ffimagebig=itemView.findViewById(R.id.add_course_image);
            ffimagesmall=itemView.findViewById(R.id.allc_image);

            fftitle=itemView.findViewById(R.id.allc_title);
            fftopic=itemView.findViewById(R.id.allc_topic);
            ffauthor=itemView.findViewById(R.id.allc_author);

            int i=getAdapterPosition();

            MainActivity k = new MainActivity();
            k.getdatatotop();

            int  ll= WImgAdapter2.webtop;

            WebTopicsActivity l = new WebTopicsActivity();
            //           int prevtopic = Integer.parseInt(l.getadaptpos);


            final String[] videoid = new String[1];
            ArrayList jk=new ArrayList();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int ki=0;ki<k.videoIds.size();ki++)
                        if(k.course_id.get(ki)==2 && k.topic.get(ki)==ll) {
                            webvv.add(k.videoIds.get(ki));
                            System.out.println("ki is this = " +ki  +"\n video "+k.vtitle.get(ki));
                        }

//                            videoid[0] = k.videoIds.get(ki);
                    String ji= webvv.get(getAdapterPosition());
                    int ij=getAdapterPosition();
                    System.out.println("this is prev "+ll);
                    System.out.println("This is the" +videoid[0]);
                    System.out.println("This is the pos" +getAdapterPosition());


                    if (getAdapterPosition() == ij) {
                        Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
                        intent.putExtra("VIDEOID", ji);
                        itemView.getContext().startActivity(intent);
                        Activity activity = (Activity) itemView.getContext();
                        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }

                }
            });

        }

    }


}


