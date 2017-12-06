package com.zhongzi.taomanjia.model.net;

import android.util.Log;

import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.entity.res.base.HttpResult;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.utils.log.LogUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/11/14.
 * 作用：
 * 在onError中进行统一的异常处理，得到更直接详细的异常信息
 * 在onNext中进行统一操作，如请求回来后，先判断token是否失效，如果失效则直接跳转登录页面
 * 在onNext中对返回的结果进行处理，得到更直接的数据信息
 * 可在onSubscribe中进行请求前的操作，注意，onSubscribe是执行在 subscribe() 被调用时的线程，所以如果在onSubscribe里进行UI操作，就要保证subscribe()也是调用在UI线程里。
 */

public abstract class HttpObserver<T> implements Observer<HttpResult<T>> {

//    private

    @Override
    public void onSubscribe(Disposable d) {
        LogUtil.e("--onSubscribe---");
    }


    @Override
    public void onComplete() {
        LogUtil.e("--onComplete---");
    }

    @Override
    public void onError(Throwable e) {
        LogUtil.e("--onError---");
        if (e instanceof Exception) {
            //访问获得对应的Exception
            ExceptionHandler.ResponseThrowable responseThrowable = ExceptionHandler.handleException(e);
            onError(responseThrowable.code, responseThrowable.message);
        } else {
            //将Throwable 和 未知错误的status code返回
            ExceptionHandler.ResponseThrowable responseThrowable = new ExceptionHandler.ResponseThrowable(e, ExceptionHandler.ERROR.UNKNOWN);
            onError(responseThrowable.code, responseThrowable.message);
        }
    }

    @Override
    public void onNext(HttpResult<T> httpResult) {
        //做一些回调后需统一处理的事情
        //如请求回来后，先判断token是否失效
        //如果失效则直接跳转登录页面
        //...
        //如果没失效，则正常回调
        check(httpResult);
    }
    private void check(HttpResult<T> httpResult) {
        if (httpResult.isCode()){
//            LogUtil.e("HttpResult正确测试"+httpResult.getInfo().toString());
            onNext(httpResult.getMessage(), httpResult.getInfo());
        }else {
//            LogUtil.e("HttpResult正确测试",httpResult.getMessage());
            ToastUtil.show(httpResult.getMessage());
            onError(BaseConstants.NOT_DATA, httpResult.getMessage());
        }
    }
    //具体实现下面两个方法，便可从中得到更直接详细的信息
    public abstract void onNext(String title, T t);
    public abstract void onError(int errType, String errMessage);
}
