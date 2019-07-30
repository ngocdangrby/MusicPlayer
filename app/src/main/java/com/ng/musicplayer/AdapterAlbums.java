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

    public AdapterAlbums(boolean pager, List<Album> albums) {
        mAlbums = albums;
        mPager = pager;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.album_adapter, parent, false));
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

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView nameTextView;
        public TextView artistTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.album_image);
            nameTextView = (TextView) itemView.findViewById(R.id.album_name);
            artistTextView = (TextView) itemView.findViewById(R.id.album_artist);
        }

    }

}

