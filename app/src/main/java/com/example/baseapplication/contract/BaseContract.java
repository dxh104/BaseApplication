package com.example.baseapplication.contract;

import android.content.Context;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

/**
 * Created by XHD on 2020/08/12
 */
public interface BaseContract {
    /**
     * 这里是最基层的mode,因为不同的view有不同的mode，但有功能相同的网络操作，便可以在mode里写接
     * 口，便于扩展
     */
    interface IModel {
    }

    /**
     * 这里是是一些更新Activity也就是更新view的接口，最基层，以便不同view扩展
     */
    interface IView {//所有的view（Activity、FragmentActivity、Fragment...）都必须实现这个接口

        void showLoadingDialog();//显示加载框

        void hideLoadingDialog(); //隐藏加载框

        void requestOnError(Throwable e);//通用请求失败
    }

    /**
     * 最基层的Present接口，使得以后的具体Present都都具备这个接口属性，具备IPresenter这个接口属性，
     * 便可以调用IPresenter接口方法
     */
    interface IPresenter<V extends IView> {
        void attach(LifecycleProvider<ActivityEvent> provider, Context context, V iView);//关联视图

        void detach();//分离视图
    }
}
