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

    public Song(String title, String artist, int imageAlbum) {
        Title = title;
        Artist = artist;
        ImageAlbum = imageAlbum;
    }

    //Setter
    public void setTitle(String title) {
        Title = title;
    }
    public void setArtist(String artist) {
        Artist = artist;
    }
    public void setFile(int file) {
        File = file;
    }
    public void setImageAlbum(int imageAlbum) {
        ImageAlbum = imageAlbum;
    }


// Getter
    public String getTitle() {
        return Title;
    }
    public String getArtist() {
        return Artist;
    }
    public int getFile() {
        return File;
    }
    public int getImageAlbum() {
        return ImageAlbum;
    }






}
