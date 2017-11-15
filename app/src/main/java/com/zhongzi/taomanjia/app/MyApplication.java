package com.zhongzi.taomanjia.app;

import android.app.Application;

/**
 * Created by Administrator on 2017/11/14.
 */

public class MyApplication extends Application {
    private static MyApplication instance;
    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        MultiDex.install(this);
        //内存泄露检测
//        if (LeakCanary.isInAnalyzerProcess(this)) return;
//        refWatcher = LeakCanary.install(this);

        instance = this;

//        ToastUtil.init(this);//初始化吐司
//        LogUtil.init(true);//初始化Log打印，true表示显示打印，false表示不显示打印
//        CrashLogUtil.getInstance().init(this);//初始化崩溃输出
//        RetrofitUtil.init(this);//初始化retrofit
//        FrescoUtil.getInstance().initializeFresco(this);//初始化Fresco
//        EventBusUtil.openIndex();//开启Index加速

    }
}
