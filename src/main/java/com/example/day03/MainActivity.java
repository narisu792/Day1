package com.example.day03;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.day03.P.MainPensert;
import com.example.day03.V.MainView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private Toolbar mToolbar;
    private ViewPager mViewpager;
    private RecyclerView mRecyclerview;
    private NavigationView mCehua;
    private LinearLayout mContent;
    private DrawerLayout mDrawer;
    private List<FuLibean.ResultsBean> resultsBeans;
    private MyRecyAdapter myRecyAdapter;
    private MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        MainPensert mainPensert = new MainPensert(this);
        mainPensert.getLIst();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mCehua = (NavigationView) findViewById(R.id.cehua);
        mContent = (LinearLayout) findViewById(R.id.content);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer);


        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mCehua.setItemIconTintList(null);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.open, R.string.close);
        mDrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        mDrawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {
                mContent.setX(view.getWidth()*v);
            }

            @Override
            public void onDrawerOpened(@NonNull View view) {

            }

            @Override
            public void onDrawerClosed(@NonNull View view) {

            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });

        View view = mCehua.getHeaderView(0);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "点击头部", Toast.LENGTH_SHORT).show();
            }
        });

        /*

        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                resultsBeans.get(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });*/


        mRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));

        resultsBeans = new ArrayList<>();
        myRecyAdapter = new MyRecyAdapter(this, resultsBeans);
        mRecyclerview.setAdapter(myRecyAdapter);

        myRecyAdapter.setOnClickListener(new MyRecyAdapter.OnClickListener() {
            @Override
            public void onclicklistener(int i) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getItem(List<FuLibean.ResultsBean> list) {
        resultsBeans.addAll(list);
        myPagerAdapter = new MyPagerAdapter(this, list);
        mViewpager.setAdapter(myPagerAdapter);
        myRecyAdapter.notifyDataSetChanged();
        myPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void error(String string) {

    }
}
