package com.example.baseapplication.contract.activity;

import com.example.baseapplication.bean.CalendarInfo;
import com.example.baseapplication.contract.BaseContract;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.observers.DefaultObserver;

/**
 * Created by XHD on 2020/08/18
 */
public interface MainContract {
    //数据层
    interface IModel extends BaseContract.IModel {
        //日历详述
       void calendarDetails(LifecycleProvider<ActivityEvent> provider, String client, String timestamp, String token,DefaultObserver<CalendarInfo> observer);
    }

    //视图层
    interface IView extends BaseContract.IView {
        void showCalendarInfo(CalendarInfo calendarInfo);//展示日历信息
    }

    //逻辑层
    interface IPresenter extends BaseContract.IPresenter<IView> {
        void dealGetCalendarInfo(String client, String timestamp, String token);//处理获取的日历信息
    }
}
