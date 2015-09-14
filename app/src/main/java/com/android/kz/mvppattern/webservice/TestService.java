package com.android.kz.mvppattern.webservice;

import com.android.kz.mvppattern.webservice.response.IPAddress;

import retrofit.Call;
import retrofit.http.GET;

/**
 * User: Kevin
 * Date: 14/09/15
 * Time: 10:03 PM
 */
public interface TestService {

    @GET("/")
    Call<IPAddress> getIp();

}
