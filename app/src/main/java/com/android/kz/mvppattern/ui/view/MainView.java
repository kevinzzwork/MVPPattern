package com.android.kz.mvppattern.ui.view;

import android.content.Context;

/**
 * User: Kevin
 * Date: 14/09/15
 * Time: 9:39 PM
 */
public interface MainView {

    Context getContext();

    void refreshResult(String result);
}
