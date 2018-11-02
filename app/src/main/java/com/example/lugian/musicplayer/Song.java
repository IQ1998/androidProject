package com.example.lugian.musicplayer;

import android.widget.ImageView;

public class Song {
    private String Title;
    private String Artist;
    private int ImageAlbum;
    private int File;

    public Song(String title, int imageAlbum, String artist, int file) {
        Artist = artist;
        Title = title;
        ImageAlbum = imageAlbum;
        File = file;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public int getImageAlbum() {
        return ImageAlbum;
    }

    public void setImageAlbum(int imageAlbum) {
        ImageAlbum = imageAlbum;
    }

    public int getFile() {
        return File;
    }

    public void setFile(int file) {
        File = file;
    }
}
