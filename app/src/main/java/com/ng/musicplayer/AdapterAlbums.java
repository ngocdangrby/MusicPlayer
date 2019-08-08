package com.ng.musicplayer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterAlbums extends RecyclerView.Adapter<AdapterAlbums.ViewHolder> {

    private List<Album> mAlbums;
    private boolean mPager;
    private OnAlbumListener onAlbumListener;

    public AdapterAlbums(boolean pager, List<Album> albums, OnAlbumListener onAlbumListener) {
        mAlbums = albums;
        mPager = pager;
        this.onAlbumListener = onAlbumListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_adapter, parent, false), onAlbumListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Album app = mAlbums.get(position);
        holder.imageView.setImageResource(app.getImage());
        holder.nameTextView.setText(app.getAlbumName());
        holder.artistTextView.setText(String.valueOf(app.getArtist()));

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mAlbums.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageView;
        public TextView nameTextView;
        public TextView artistTextView;
        public OnAlbumListener onAlbumListener;

        public ViewHolder(View itemView, OnAlbumListener onAlbumListener) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.album_image);
            nameTextView = (TextView) itemView.findViewById(R.id.album_name);
            artistTextView = (TextView) itemView.findViewById(R.id.album_artist);
            this.onAlbumListener = onAlbumListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onAlbumListener.onAlbumClick(getAdapterPosition());
        }
    }

    public interface OnAlbumListener {
        void onAlbumClick(int position);
    }

}

