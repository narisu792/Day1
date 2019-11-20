package com.example.day03.M;

import com.example.day03.APIServer;
import com.example.day03.CallBack.MainCallBack;
import com.example.day03.FuLibean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainMolder implements MVPMolder {
    @Override
    public void getData(final MainCallBack mainCallBack) {
        Retrofit builder = new Retrofit.Builder()
                .baseUrl(APIServer.STRING)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Observable<FuLibean> data = builder.create(APIServer.class).getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FuLibean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FuLibean value) {
                        mainCallBack.getItem(value.getResults());
                    }

                    @Override
                    public void onError(Throwable e) {
                        mainCallBack.error("网络请求失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
