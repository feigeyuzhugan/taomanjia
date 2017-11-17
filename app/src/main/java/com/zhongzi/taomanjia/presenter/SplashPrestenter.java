package com.zhongzi.taomanjia.presenter;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iView.ISplashView;

/**
 * Created by Administrator on 2017/11/15.
 */

public class SplashPrestenter extends BasePresenter<ISplashView>{
    private static final String TAG = SplashPrestenter.class.getSimpleName();
    public SplashPrestenter(ISplashView splashPresenter) {
        super(splashPresenter);
    }
    public void setAnim(ImageView view){
//        view.animate().alpha(0).setDuration(3000)
        Animation animation= new AlphaAnimation(0.4f,1f);
        animation.setDuration(3000);
        view.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mIView.startAnim();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
