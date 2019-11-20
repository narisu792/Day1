package com.example.day03.P;

import com.example.day03.CallBack.MainCallBack;
import com.example.day03.FuLibean;
import com.example.day03.M.MainMolder;
import com.example.day03.V.MainView;

import java.util.List;

public class MainPensert implements MainOpensert,MainCallBack {

    private final MainMolder mainMolder;

    public MainPensert(MainView mainView) {
        this.mainView = mainView;
        mainMolder = new MainMolder();
    }

    private MainView mainView;
    @Override
    public void getLIst() {
        if (mainMolder!=null)
        {
            mainMolder.getData(this);
        }
    }

    @Override
    public void getItem(List<FuLibean.ResultsBean> list) {
        if (mainView!=null)
        {
            mainView.getItem(list);
        }
    }

    @Override
    public void error(String string) {
        if (mainView!=null)
        {
            mainView.error(string);
        }
    }
}
