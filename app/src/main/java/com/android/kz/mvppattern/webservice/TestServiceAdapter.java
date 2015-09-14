package com.android.kz.mvppattern.webservice;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import retrofit.Converter;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * User: Kevin
 * Date: 14/09/15
 * Time: 9:57 PM
 */
public class TestServiceAdapter {
    private final static String END_POINT = "http://ip.jsontest.com/";

    private TestService testService;

    private static class TestServiceAdapterHolder {
        private static final TestServiceAdapter MVP_BUS_HOLDER = new TestServiceAdapter(END_POINT);
    }

    public static TestServiceAdapter getInstance() {
        return TestServiceAdapterHolder.MVP_BUS_HOLDER;
    }

    private TestServiceAdapter(String endPoint) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(endPoint)
                .build();

        testService = retrofit.create(TestService.class);
    }

    public TestService getTestService() {
        return testService;
    }

}
