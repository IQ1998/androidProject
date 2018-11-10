package com.example.lugian.musicplayer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Search_Fragment_Adapter extends FragmentPagerAdapter {
    private final int count = 2;
    private String title[] = new String[] {"Song","Artist"};

    public Search_Fragment_Adapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0: return new Search_Fragment_Song();
            case 1: return new Search_Fragment_Artist();
        }
        return new Fragment();
    }

    @Override
    public int getCount() {
        return count;
    }

    public CharSequence getPageTitle(int page){
        return title[page];
    }
}
