package com.my.bat.interfaces;

import com.my.bat.bean.News;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("api/data/Android/10/1")
    Call<News> getnews();
}