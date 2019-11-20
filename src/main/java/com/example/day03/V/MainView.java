package com.example.day03.V;

import com.example.day03.FuLibean;

import java.util.List;

public interface MainView {
    void getItem(List<FuLibean.ResultsBean> list);
    void error(String string);
}
