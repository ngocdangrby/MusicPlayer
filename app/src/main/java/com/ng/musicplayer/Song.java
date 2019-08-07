package com.ng.musicplayer;

import android.graphics.drawable.Drawable;

public class Song {
    private String name;
    private String artist;
    private boolean isLiked;
    private int length;
    private int  image;

    public Song(String name, String artist, boolean isLiked, int  image) {
        this.name = name;
        this.artist = artist;
        this.isLiked = isLiked;
        this.image = image;
    }

    public Song(String name, String artist, boolean isLiked, int length, int  image) {
        this.name = name;
        this.artist = artist;
        this.isLiked = isLiked;
        this.length = length;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int  getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
