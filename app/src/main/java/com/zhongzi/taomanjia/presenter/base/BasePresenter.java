package com.zhongzi.taomanjia.presenter.base;

import com.zhongzi.taomanjia.view.activity.base.BaseActivity;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2017/11/14.
 */

public class BasePresenter<T extends IBaseView> {
    protected T mIView;
    protected WeakReference<BaseActivity> mBaseViewActivity;

    public BasePresenter(T t, BaseActivity activity) {
        mIView = t;
        mBaseViewActivity = new WeakReference<>(activity);
    }

    public BasePresenter(BaseActivity activity) {
        mBaseViewActivity = new WeakReference<>(activity);
    }

    public BasePresenter(T t) {
        mIView = t;
    }

    public BasePresenter() {
    }

    /**
     * 释放引用，防止内存泄露
     */
    public void destroy() {
        mIView = null;
    }
}
