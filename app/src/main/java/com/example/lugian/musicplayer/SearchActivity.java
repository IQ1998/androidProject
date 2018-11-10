package com.example.lugian.musicplayer;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        PagerAdapter adapter = new Search_Fragment_Adapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.viewpager_id);
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        tabLayout.setupWithViewPager(pager);
    }
}
