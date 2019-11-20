package com.example.day03;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIServer {
    String STRING="http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/";
    @GET("1")
    Observable<FuLibean> getData();
}
