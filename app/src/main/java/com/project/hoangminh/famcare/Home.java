package com.project.hoangminh.famcare;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class Home extends AppCompatActivity {

    BottomNavigationView nav;
    FamCareViewPager pager;
    MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        nav = (BottomNavigationView) findViewById(R.id.bottom_nav);
        pager = (FamCareViewPager) findViewById(R.id.pager);

        pager.setEnable(false);

        //getSupportActionBar().setTitle("Vitals");

        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //ActionBar actionBar = getSupportActionBar();
                switch (menuItem.getItemId()) {
                    case R.id.vital:
                        pager.setCurrentItem(0);
                        //actionBar.setTitle("Vitals");
                        break;

                    case R.id.mental:
                        pager.setCurrentItem(1);
                        //actionBar.setTitle("Mental Wellness Self Assessment");
                        break;

                    case R.id.msg:
                        pager.setCurrentItem(2);
                        //actionBar.setTitle("Messages");
                        break;

                    case R.id.people:
                        pager.setCurrentItem(3);
                        //actionBar.setTitle("Staffs");
                        break;
                }
                return true;
            }
        });

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if(menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    nav.getMenu().getItem(0).setChecked(false);
                }
                nav.getMenu().getItem(i).setChecked(true);
                menuItem = nav.getMenu().getItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        setUpViewPager(pager);
    }

    private void setUpViewPager(ViewPager vp) {
        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());

        Fragment vitalFrag = new VitalFragment();
        Fragment mentalFrag = new MentalFragment();
        Fragment msgFrag = new MessageFragment();
        Fragment pplFrag = new PeopleFragment();

        vpa.addFragment(vitalFrag);
        vpa.addFragment(mentalFrag);
        vpa.addFragment(msgFrag);
        vpa.addFragment(pplFrag);

        vp.setAdapter(vpa);
    }
}
