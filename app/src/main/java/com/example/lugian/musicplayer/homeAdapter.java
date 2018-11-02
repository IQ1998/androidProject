package com.example.lugian.musicplayer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class homeAdapter extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 3;
    private String titles[] = {"HOME", "SONGS", "FAVORITES"};

    public homeAdapter(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int page) {
        // return an instance of fragment coressponding to different tab
        switch (page) {
            case 0: return new homeFragment();
            case 1: return new mp3Fragment();
            case 2: return new homeFragment();
        }
        return new Fragment();
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int page){
        //return a page title
        return titles[page];
    }
}
