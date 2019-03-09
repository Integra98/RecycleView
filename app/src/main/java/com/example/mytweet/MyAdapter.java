package com.example.mytweet;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public List<Tweet> list;


    public MyAdapter(List<Tweet> list, MainActivity listener) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_activity, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Tweet tweet = list.get(position);
        holder.mName.setText(tweet.getName());
        holder.mCompany.setText(tweet.getCompany());
        holder.mData.setText(tweet.getData());
        holder.imageView.setImageResource(tweet.getImage());
        holder.imageViewAva.setImageResource(tweet.getAva());
        holder.textLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tweet.getLike() == false){
                    TextView textLike= v.findViewById(R.id.like_text_view);
                    tweet.setLike(true);
                    textLike.setTextColor(Color.RED);
                }else{
                    TextView textLike= v.findViewById(R.id.like_text_view);
                    tweet.setLike(false);
                    textLike.setTextColor(Color.DKGRAY);
                }

            }
        });
        if(tweet.getLike() == true){
            holder.textLike.setTextColor(Color.RED);
        }



    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView mName;
        private TextView mCompany;
        private TextView mData;
        private ImageView imageView;
        private ImageView imageViewAva;
        private TextView textLike;


        public MyViewHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.author_name_text_view);
            mCompany = itemView.findViewById(R.id.author_nick_text_view);
            mData = itemView.findViewById(R.id.creation_date_text_view);
            imageView = itemView.findViewById(R.id.tweet_image_view);
            imageViewAva = itemView.findViewById(R.id.profile_image_view);
            textLike = itemView.findViewById(R.id.like_text_view);
        }
    }


}
