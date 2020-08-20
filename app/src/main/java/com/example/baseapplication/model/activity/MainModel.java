package com.example.baseapplication.model.activity;

import com.example.baseapplication.bean.CalendarInfo;
import com.example.baseapplication.contract.activity.MainContract;
import com.example.baseapplication.http.ApiUtil;
import com.example.baseapplication.manager.DataManager;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by XHD on 2020/08/18
 */
public class MainModel implements MainContract.IModel {
    //model层可以轻易复用--->model有需要可以直接实现observer先处理数据(数据库,读写数据,修改数据等等)，再用新接口回调给presenter
    @Override
    public void calendarDetails(LifecycleProvider<ActivityEvent> provider, String client, String timestamp, String token, DefaultObserver<CalendarInfo> observer) {
        ApiUtil.calendarDetails(provider, client, timestamp, token, observer);
    }

//    public void calendarDetails2(LifecycleProvider<ActivityEvent> provider, String client, String timestamp, String token, final DefaultObserver<CalendarInfo> observer) {
//        ApiUtil.calendarDetails(provider, client, timestamp, token, new DefaultObserver<CalendarInfo>() {
//            @Override
//            public void onNext(CalendarInfo calendarInfo) {
//                observer.onNext(calendarInfo);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                observer.onError(e);
//            }
//
//            @Override
//            public void onComplete() {
//                observer.onComplete();
//            }
//        });
//    }
}
