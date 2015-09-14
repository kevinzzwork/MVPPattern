package com.android.kz.mvppattern.ui.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.kz.mvppattern.R;
import com.android.kz.mvppattern.presenter.MainPresenter;
import com.android.kz.mvppattern.presenter.MainPresenterImpl;
import com.android.kz.mvppattern.ui.view.MainView;
import com.android.kz.mvppattern.utils.LogUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {
    @Bind(R.id.resultTextView) TextView resultTextView;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenterImpl(this);
    }

    @OnClick(R.id.testBtn)
    public void testBtnClicked() {
        LogUtil.d("---- MainActivity ----  testBtnClicked ----");
        presenter.testBtnClicked();
    }

    @Override
    protected void onDestroy() {
        presenter.close();
        super.onDestroy();
    }

    /******************
     * MainView methods
     ******************/
    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void refreshResult(String result) {
        LogUtil.d("---- MainActivity ----  refresh IP address text view ----");
        resultTextView.setText(result);
    }
}
