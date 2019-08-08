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
    private OnSongListener onSongListener;

    public SongAdapter(List<Song> mSongs, OnSongListener onSongListener) {
        this.onSongListener = onSongListener;
        this.mSongs = mSongs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_song, parent, false), onSongListener);
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

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageView;
        public TextView nameTextView;
        public TextView artistTextView;
        public OnSongListener onSongListener;

        public ViewHolder(View itemView, OnSongListener onSongListener) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageSong);
            nameTextView = (TextView) itemView.findViewById(R.id.tv_song_name);
            artistTextView = (TextView) itemView.findViewById(R.id.tv_artist_name);
            this.onSongListener = onSongListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onSongListener.OnSongClick(getAdapterPosition());
        }
    }

    interface OnSongListener {
        void OnSongClick(int pos);
    }

}

