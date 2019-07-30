package com.ng.musicplayer;

import java.util.List;

public class ListOfListAlbums {
    private String listName;
    private List<Album> mAlbums;

    public ListOfListAlbums(String listName, List<Album> mAlbums) {
        this.listName = listName;
        this.mAlbums = mAlbums;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<Album> getmAlbums() {
        return mAlbums;
    }

    public void setmAlbums(List<Album> mAlbums) {
        this.mAlbums = mAlbums;
    }
}
