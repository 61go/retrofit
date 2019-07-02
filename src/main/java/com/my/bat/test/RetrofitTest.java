package com.my.bat.test;

import com.my.bat.bean.News;
import com.my.bat.interfaces.Api;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

/**
 * @ClassName RetrofitTest
 * @Description TODO
 * @Author huruipeng
 * @Date 2019/7/1 15:27
 * @Version 1.0
 * @Copyright: Copyright (c) 2018
 * @Company:京东城市
 **/

public class RetrofitTest {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gank.io/")//接入BaseUrl
                .addConverterFactory(GsonConverterFactory.create())//使用之前我们引入的RetrofitGson进行添加一个转换器
                .build();
        Api api = retrofit.create(Api.class);
        Call<News> getnews = api.getnews();
        getnews.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (response.isSuccessful()) {
                    List<News.ResultsBean> results = response.body().getResults();
                    results.stream().forEach(x -> System.out.println(x));
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable throwable) {

            }
        });


    }
}
