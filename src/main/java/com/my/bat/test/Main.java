//package com.my.bat.test;
//
//import okhttp3.*;
//import okhttp3.logging.HttpLoggingInterceptor;
//import org.jetbrains.annotations.NotNull;
//
//import java.io.IOException;
//import java.net.InetAddress;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
///**
// * @ClassName Main
// * @Description TODO
// * @Author huruipeng
// * @Date 2019/6/27 9:34
// * @Version 1.0
// * @Copyright: Copyright (c) 2018
// * @Company:京东城市
// **/
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        //启用Log日志
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLog());
//        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
//        ConnectionPool cp = new ConnectionPool(4,2L,TimeUnit.SECONDS);
//        OkHttpClient ok = new OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).connectionPool(cp).connectTimeout(3L, TimeUnit.SECONDS).callTimeout(3L, TimeUnit.SECONDS).build();
//        Request req = new Request.Builder().url("https://www.baidu.com").get().build();
//        Call call = ok.newCall(req);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                e.printStackTrace();
//                System.out.println("On failure");
//            }
//
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                System.out.println("on suc");
//                ResponseBody body = response.body();
//                String string = body.string();
//                System.out.println(string);
//            }
//        });
//
//        Dns dns = ok.dns();
//        List<InetAddress> lookup =
//                dns.lookup("www.baidu.com");
//        lookup.parallelStream().forEach(x-> {
//            try {
//                System.out.println(x.getHostAddress());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }
//}
