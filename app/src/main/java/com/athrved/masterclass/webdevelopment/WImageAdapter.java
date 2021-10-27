package com.athrved.masterclass.webdevelopment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athrved.masterclass.R;
import com.athrved.masterclass.Upload;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WImageAdapter extends RecyclerView.Adapter<WImageAdapter.ImageViewHolder> {
    private Context mContext;
    private List<Upload> mUploads;

    public WImageAdapter(Context context, List<Upload> uploads){
        mContext = context;
        mUploads = uploads;
    }

    @NonNull
    @Override
    public WImageAdapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item,parent,false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WImageAdapter.ImageViewHolder holder, int position) {
        Upload uploadCurrent = mUploads.get(position);
        holder.textViewName.setText(uploadCurrent.getmName());
        holder.textViewEmail.setText(uploadCurrent.getmEmail());
        holder.textViewPhNo.setText(uploadCurrent.getPhoneNo());
        holder.textViewDesignation.setText(uploadCurrent.getDesignation());
        holder.textViewDesc.setText(uploadCurrent.getDesc());
        Picasso.get().load(uploadCurrent.getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName, textViewDesignation, textViewDesc, textViewPhNo, textViewEmail;
        public ImageView imageView;
        public ImageViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_upload);
            textViewEmail = itemView.findViewById(R.id.text_view_email);
            textViewDesignation = itemView.findViewById(R.id.text_view_designation);
            textViewDesc = itemView.findViewById(R.id.text_view_desc);
            textViewPhNo = itemView.findViewById(R.id.text_view_phNumber);
        }
    }
}

