package com.example.day03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.day03.P.MainPensert;
import com.example.day03.V.MainView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements MainView, View.OnClickListener {

    private ViewPager mViewpager1;
    private List<FuLibean.ResultsBean> resultsBeans;
    private MyPagerAdapter1 myPagerAdapter1;
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initData();
        initView();

    }

    private void initData() {
        MainPensert mainPensert = new MainPensert(this);
        mainPensert.getLIst();
    }

    private void initView() {
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);


        mViewpager1 = (ViewPager) findViewById(R.id.viewpager1);
        resultsBeans = new ArrayList<>();
        myPagerAdapter1 = new MyPagerAdapter1(this, resultsBeans);
        mViewpager1.setAdapter(myPagerAdapter1);


    }

    @Override
    public void getItem(List<FuLibean.ResultsBean> list) {
        resultsBeans.addAll(list);
        myPagerAdapter1.notifyDataSetChanged();
    }

    @Override
    public void error(String string) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                // TODO 19/11/20
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
