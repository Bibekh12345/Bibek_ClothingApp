package com.bibek_clothingapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import adapter.PageViewAdapter;
import fragment.LoginFragment;
import fragment.RegisterFragment;

public class PageViewActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_page_view);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabId);

        PageViewAdapter pageViewAdapter = new PageViewAdapter(getSupportFragmentManager());

        pageViewAdapter.addFragment(new LoginFragment(),"Login");
        pageViewAdapter.addFragment(new RegisterFragment(),"Register");

        viewPager.setAdapter(pageViewAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
