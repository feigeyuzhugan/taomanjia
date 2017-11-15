package com.zhongzi.taomanjia.model.net;

/**
 * Created by Administrator on 2017/11/14.
 * 用于Retrofit监控当前View层生命周期的状态值
 */

public enum LifeCycleEvent {
    CREATE,
    START,
    RESUME,
    PAUSE,
    STOP,
    DESTROY
}
