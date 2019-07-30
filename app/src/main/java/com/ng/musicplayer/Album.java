package com.ng.musicplayer;

import android.graphics.drawable.Drawable;

public class Album {
    private String albumName;
    private String artist;
   private int image;

    public Album(String albumName, String artist, int image) {
        this.albumName = albumName;
        this.artist = artist;
        this.image = image;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
