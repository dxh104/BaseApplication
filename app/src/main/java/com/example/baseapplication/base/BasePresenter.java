package com.example.baseapplication.base;

import android.content.Context;

import com.example.baseapplication.contract.BaseContract;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.lang.ref.WeakReference;

/**
 * Created by XHD on 2020/08/12
 */
//BasePresenter负责创建M,附加/分离V,实现基类接口  (M,V中间层)
public abstract class BasePresenter<M extends BaseContract.IModel, V extends BaseContract.IView> implements BaseContract.IPresenter<V> {

    private WeakReference<LifecycleProvider<ActivityEvent>> mRefProvider;//弱引用provider
    private WeakReference<Context> mRefContext;//弱引用视图上下文
    private WeakReference<V> mRefIView;//弱引用视图接口
    private M mModel;

    @Override
    public void attach(LifecycleProvider<ActivityEvent> provider, Context context, V iView) {
        mRefProvider = new WeakReference<>(provider);
        mRefIView = new WeakReference<>(iView);
        mRefContext = new WeakReference<>(context);
        mModel = createModel();
    }


    @Override
    public void detach() {//分离视图，清除关联
        if (mRefProvider != null) {
            mRefProvider.clear();
            mRefProvider = null;
        }
        if (mRefIView != null) {
            mRefIView.clear();
            mRefIView = null;
        }
        if (mRefContext != null) {
            mRefContext.clear();
            mRefContext = null;
        }
    }

    //创建Model对象
    protected abstract M createModel();

    //获取Model对象
    protected M getModel() {
        return mModel;
    }

    //获取provider
    public LifecycleProvider<ActivityEvent> getLifecycleProvider() {
        if (mRefProvider != null) {//防空
            return mRefProvider.get();
        }
        return null;
    }

    //获取视图层上下文
    protected Context getMcontext() {
        if (mRefContext != null) {//防空
            return mRefContext.get();
        }
        return null;
    }

    //获取视图层接口
    protected V getIView() {
        if (mRefIView != null) {//防空
            return mRefIView.get();
        }
        return null;
    }

    //显示加载框
    public void showLoadingDialog() {
        if (getIView() != null)
            getIView().showLoadingDialog();
    }


    //隐藏加载框
    public void hideLoadingDialog() {
        if (getIView() != null) {
            getIView().hideLoadingDialog();
        }
    }
}
