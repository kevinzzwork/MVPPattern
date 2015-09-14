package com.android.kz.mvppattern.presenter;

import com.android.kz.mvppattern.model.MainExecutor;
import com.android.kz.mvppattern.model.MainExecutorImpl;
import com.android.kz.mvppattern.otto.MVPBus;
import com.android.kz.mvppattern.otto.event.GetIPAddressEvent;
import com.android.kz.mvppattern.otto.event.GetIPAddressResultEvent;
import com.android.kz.mvppattern.ui.view.MainView;
import com.android.kz.mvppattern.utils.LogUtil;
import com.squareup.otto.Subscribe;

/**
 * User: Kevin
 * Date: 14/09/15
 * Time: 9:39 PM
 */
public class MainPresenterImpl implements MainPresenter {
    private MainView mainView;
    private MainExecutor executor;

    public MainPresenterImpl(MainView mainView) {
        MVPBus.getInstance().register(this);
        executor = new MainExecutorImpl();
        this.mainView = mainView;
    }

    @Override
    public void testBtnClicked() {
        LogUtil.d("---- MainPresenter ----  testBtnClicked ----");
        LogUtil.d("---- MainPresenter ----  send get IP address event ----");
        MVPBus.getInstance().post(new GetIPAddressEvent());
    }

    @Override
    public void close() {
        MVPBus.getInstance().unregister(this);
        executor.close();
    }

    @Subscribe
    public void receivedResultEvent(GetIPAddressResultEvent resultEvent) {
        LogUtil.d("---- MainPresenter ----  received IP address ----");
        LogUtil.d("---- MainPresenter ----  refresh IP address text view ----");
        mainView.refreshResult(resultEvent.getIpAdderss());
    }
}
