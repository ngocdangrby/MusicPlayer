package com.ng.musicplayer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private List<Song> mSongs;
    private boolean mPager;

    public SongAdapter(List<Song> mSongs) {
        this.mSongs = mSongs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_song, parent, false));
//        if (mPager) {
//            return new ViewHolder(LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.albums_adapter_pager, parent, false));
//        } else {
//            return mHorizontal ? new ViewHolder(LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.adapter, parent, false)) :
//                    new ViewHolder(LayoutInflater.from(parent.getContext())
//                            .inflate(R.layout.adapter_vertical, parent, false));
//        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Song app = mSongs.get(position);
        holder.imageView.setImageResource(app.getImage());
        holder.nameTextView.setText(app.getName());
        holder.artistTextView.setText(String.valueOf(app.getArtist()));

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView nameTextView;
        public TextView artistTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageSong);
            nameTextView = (TextView) itemView.findViewById(R.id.tv_song_name);
            artistTextView = (TextView) itemView.findViewById(R.id.tv_artist_name);
        }

    }

}

