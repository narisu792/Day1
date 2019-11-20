package com.example.day03.CallBack;

import com.example.day03.FuLibean;

import java.util.List;

public interface MainCallBack {
    void getItem(List<FuLibean.ResultsBean> list);
    void error(String string);
}
