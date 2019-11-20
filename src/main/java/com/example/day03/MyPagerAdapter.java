package com.example.day03;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyPagerAdapter extends PagerAdapter {

    Context context;
    List<FuLibean.ResultsBean> resultsBeans;

    public MyPagerAdapter(Context context, List<FuLibean.ResultsBean> resultsBeans) {
        this.context = context;
        this.resultsBeans = resultsBeans;
    }

    @Override
    public int getCount() {
        return resultsBeans.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.pager_item, null);
        ImageView img = view.findViewById(R.id.img);
        container.addView(view);
        for (int i = 0; i < resultsBeans.size(); i++) {
            Glide.with(context).load(resultsBeans.get(position).getUrl()).into(img);
        }
        return view;
    }

}
