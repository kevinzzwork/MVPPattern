package com.android.kz.mvppattern.model;

import android.os.AsyncTask;

import com.android.kz.mvppattern.otto.MVPBus;
import com.android.kz.mvppattern.otto.event.GetIPAddressEvent;
import com.android.kz.mvppattern.otto.event.GetIPAddressResultEvent;
import com.android.kz.mvppattern.utils.LogUtil;
import com.android.kz.mvppattern.webservice.TestServiceAdapter;
import com.android.kz.mvppattern.webservice.response.IPAddress;
import com.squareup.otto.Subscribe;

import java.io.IOException;

import retrofit.Call;

/**
 * User: Kevin
 * Date: 14/09/15
 * Time: 9:48 PM
 */
public class MainExecutorImpl implements MainExecutor {

    public MainExecutorImpl() {
        MVPBus.getInstance().register(this);
    }

    @Override
    public void close() {
        MVPBus.getInstance().unregister(this);
    }

    @Subscribe
    public void receivedGetIPAddressEvent(GetIPAddressEvent event) {
        LogUtil.d("---- MainExecutor ----  received get IP address event ----");
        new GetIPAddressTask().execute();
    }

    class GetIPAddressTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                LogUtil.d("---- MainExecutor ----  do get IP address webservice ----");
                Call<IPAddress> ipAddressCall = TestServiceAdapter.getInstance().getTestService().getIp();
                IPAddress ipAddress = ipAddressCall.execute().body();
                return ipAddress.getIp();
            } catch (IOException e) {
            }
            return "";
        }

        @Override
        protected void onPostExecute(String ipAddress) {
            LogUtil.d("---- MainExecutor ----  send IP address webservice result ----  ip : " + ipAddress);
            // Send result event back to presenter
            GetIPAddressResultEvent resultEvent = new GetIPAddressResultEvent();
            resultEvent.setIpAdderss(ipAddress);
            MVPBus.getInstance().post(resultEvent);
        }
    }
}
