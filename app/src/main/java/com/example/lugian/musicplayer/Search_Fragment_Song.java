package com.example.lugian.musicplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Search_Fragment_Song extends Fragment {


    View v;
    private RecyclerView myrecycleview;
    private List<Song> listSong;


    public Search_Fragment_Song() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.search__fragment__song, container, false);
        myrecycleview = (RecyclerView) v.findViewById(R.id.recycler_song);
        Search_Recycler_Adapter recyclerAdapter = new Search_Recycler_Adapter(getContext(),listSong);
        myrecycleview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycleview.setAdapter(recyclerAdapter);
        return v;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listSong = new ArrayList<>();
        listSong.add(new Song("Thang dien","Justatee",R.drawable.thang_dien));
        listSong.add(new Song("Thang dien","Justatee",R.drawable.thang_dien));
        listSong.add(new Song("Thang dien","Justatee",R.drawable.thang_dien));
        listSong.add(new Song("Thang dien","Justatee",R.drawable.thang_dien));
        listSong.add(new Song("Thang dien","Justatee",R.drawable.thang_dien));
        listSong.add(new Song("Thang dien","Justatee",R.drawable.thang_dien));
        listSong.add(new Song("Thang dien","Justatee",R.drawable.thang_dien));
        listSong.add(new Song("Thang dien","Justatee",R.drawable.thang_dien));
    }
}
