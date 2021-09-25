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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class WebFewAllAdapter extends RecyclerView.Adapter<WebFewAllAdapter.WebFewAllViewHolder> {

    ArrayList<WebFewAllHelperClass> featloc;
     static String v_id1 ;
     static String v_id2 ;
     static String v_id3 ;
     static String vtitle1 ;
     static String vtitle2 ;
     static String vtitle3 ;

    DatabaseReference reff;

    public WebFewAllAdapter(ArrayList<WebFewAllHelperClass> featloc) {
        this.featloc = featloc;
    }

    @NonNull

    @Override
    public WebFewAllViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_all_classes,parent,false);
        WebFewAllViewHolder WebFewAllViewHolder = new WebFewAllViewHolder(view);

        return WebFewAllViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WebFewAllViewHolder holder, int position) {
        WebFewAllHelperClass WebFewAllHelperClass = featloc.get(position);
        holder.wimagebig.setImageResource(WebFewAllHelperClass.getWimagebig());
        holder.wimagesmall.setImageResource(WebFewAllHelperClass.getWimagesmall());
        holder.wtitle.setText(WebFewAllHelperClass.getWtitle());
        holder.wtopic.setText(WebFewAllHelperClass.getWchannel());
        holder.wauthor.setText(WebFewAllHelperClass.getWauthor());

        for(int k =1;k<=3;k++){
            String ka=String.valueOf(k);
            reff= FirebaseDatabase.getInstance().getReference("video").child("web").child("free").child(ka);
            int finalK = k;
            reff.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(finalK ==1) {
                        v_id1 = snapshot.child("video_Id").getValue().toString();
                        vtitle1=snapshot.child("title_video").getValue().toString();
                    }
                    if(finalK ==2) {
                        v_id2 = snapshot.child("video_Id").getValue().toString();
                        vtitle2=snapshot.child("title_video").getValue().toString();

                    }
                    if(finalK ==3) {
                        v_id3 = snapshot.child("video_Id").getValue().toString();
                        vtitle3=snapshot.child("title_video").getValue().toString();

                    }

                    if (holder.getAdapterPosition() == 0) {
                        holder.wtitle.setText(vtitle1);
                        Picasso.get().load("https://img.youtube.com/vi/" + v_id1 + "/maxresdefault.jpg").into(holder.wimagebig);
                    }
                    if (holder.getAdapterPosition() == 1) {
                        holder.wtitle.setText(vtitle2);
                        Picasso.get().load("https://img.youtube.com/vi/" + v_id2 + "/maxresdefault.jpg").into(holder.wimagebig);
                    }
                    if (holder.getAdapterPosition() == 2) {
                        holder.wtitle.setText(vtitle3);
                        Picasso.get().load("https://img.youtube.com/vi/" + v_id3 + "/maxresdefault.jpg").into(holder.wimagebig);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }



    @Override
    public int getItemCount() {
        return featloc.size();
    }

    public static class WebFewAllViewHolder extends RecyclerView.ViewHolder{
        ImageView wimagebig, wimagesmall;
        TextView wtitle, wtopic, wauthor;


        public WebFewAllViewHolder(@NonNull final View itemView){
            super(itemView);

            wimagebig=itemView.findViewById(R.id.add_course_image);
            wimagesmall=itemView.findViewById(R.id.allc_image);

            wtitle=itemView.findViewById(R.id.allc_title);
            wtopic=itemView.findViewById(R.id.allc_topic);
            wauthor=itemView.findViewById(R.id.allc_author);


            for(int k =1;k<=3;k++){
                String ka=String.valueOf(k);
                DatabaseReference reff= FirebaseDatabase.getInstance().getReference("video").child("uiux").child("free").child(ka);
                int finalK = k;
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(finalK ==1) {
                            v_id1 = snapshot.child("video_Id").getValue().toString();
                            vtitle1=snapshot.child("title_video").getValue().toString();
                        }
                        if(finalK ==2) {
                            v_id2 = snapshot.child("video_Id").getValue().toString();
                            vtitle2=snapshot.child("title_video").getValue().toString();

                        }
                        if(finalK ==3) {
                            v_id3 = snapshot.child("video_Id").getValue().toString();
                            vtitle3=snapshot.child("title_video").getValue().toString();
                        }

                        itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (getAdapterPosition() == 0) {
                                    Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
                                    intent.putExtra("VIDEOID", v_id1);
                                    intent.putExtra("VTITLE",vtitle1);
                                    itemView.getContext().startActivity(intent);
                                    Activity activity = (Activity) itemView.getContext();
                                    activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                                }

                                if (getAdapterPosition() == 1) {
                                    Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
                                    intent.putExtra("VIDEOID", v_id2);
                                    intent.putExtra("VTITLE",vtitle2);
                                    itemView.getContext().startActivity(intent);
                                    Activity activity = (Activity) itemView.getContext();
                                    activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                                }

                                if (getAdapterPosition() == 2) {
                                    Intent intent = new Intent(itemView.getContext(), PlayerActivity.class);
                                    intent.putExtra("VIDEOID", v_id3);
                                    intent.putExtra("VTITLE",vtitle3);
                                    itemView.getContext().startActivity(intent);
                                    Activity activity = (Activity) itemView.getContext();
                                    activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                                }

                            }
                        });

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }


























        }



    }


}
