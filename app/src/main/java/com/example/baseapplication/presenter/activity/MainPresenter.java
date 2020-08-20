package com.example.baseapplication.presenter.activity;

import com.example.baseapplication.base.BasePresenter;
import com.example.baseapplication.bean.CalendarInfo;
import com.example.baseapplication.contract.activity.MainContract;
import com.example.baseapplication.model.activity.MainModel;

import io.reactivex.observers.DefaultObserver;

/**
 * Created by XHD on 2020/08/18
 */
public class MainPresenter extends BasePresenter<MainContract.IModel, MainContract.IView> implements MainContract.IPresenter {
    @Override
    protected MainContract.IModel createModel() {
        return new MainModel();
    }

    @Override
    public void dealGetCalendarInfo(String client, String timestamp, String token) {
        showLoadingDialog();
        getModel().calendarDetails(getLifecycleProvider(), client, timestamp, token, new DefaultObserver<CalendarInfo>() {
            @Override
            public void onNext(CalendarInfo calendarInfo) {
                getIView().showCalendarInfo(calendarInfo);
            }

            @Override
            public void onError(Throwable e) {
                getIView().requestOnError(e);
            }

            @Override
            public void onComplete() {
                hideLoadingDialog();
            }
        });
    }
}
