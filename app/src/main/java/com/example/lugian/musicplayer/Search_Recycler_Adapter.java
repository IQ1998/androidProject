package com.example.lugian.musicplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Search_Recycler_Adapter extends RecyclerView.Adapter<Search_Recycler_Adapter.MyViewHolder> {
    Context mContext;
    List<Song> mData;

    public Search_Recycler_Adapter(Context mContext, List<Song> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_song,viewGroup,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        myViewHolder.tv_name.setText(mData.get(position).getTitle());
        myViewHolder.tv_artist.setText(mData.get(position).getArtist());
        myViewHolder.img.setImageResource(mData.get(position).getImageAlbum());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_artist;
        private ImageView img;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.song_name);
            tv_artist = (TextView) itemView.findViewById(R.id.artist_name);
            img = (ImageView) itemView.findViewById(R.id.img_songname);
        }
    }
}
