package com.example.baseapplication.view.activity;

import android.view.View;
import android.widget.TextView;

import com.example.baseapplication.R;
import com.example.baseapplication.base.BaseActivity;
import com.example.baseapplication.bean.CalendarInfo;
import com.example.baseapplication.contract.activity.MainContract;
import com.example.baseapplication.presenter.activity.MainPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainContract.IView, MainPresenter> implements MainContract.IView {


    @BindView(R.id.tv_data)
    TextView tvData;

    @OnClick(R.id.btn_getData)
    public void onViewClicked() {
        //处理获取的数据
        getmPresenter().dealGetCalendarInfo("ceshi", "1462377600", "CD78D9012F1C063E54C640EA27952F80");
    }

    protected int setContentLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        View actionBar = setActionBar("首页");
    }

    @Override
    protected void initData() {

    }


    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected MainContract.IView getIView() {
        return this;
    }


    @Override
    public void showCalendarInfo(CalendarInfo calendarInfo) {
        tvData.setText(calendarInfo.toString());
    }


}
