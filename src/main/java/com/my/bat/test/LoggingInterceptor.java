package com.my.bat.test;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class LoggingInterceptor implements Interceptor {
    private static final String TAG = "LoggingInterceptor";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url();
        System.out.println("log拦截：" + url.toString());
        long startTime = System.nanoTime();

        Response response = chain.proceed(request);

        long endTime = System.nanoTime();
//        String string = response.body().string();
//        System.out.println(string);
        return response;
    }
}