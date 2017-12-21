package com.zhongzi.taomanjia.view.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2017/12/15.
 * 数字跳到的自定义控件
 */

public class RiseNumberTextView extends AppCompatTextView {
    private static final int STOPPED = 0;

    private static final int RUNNING = 1;

    private int mPlayingState = STOPPED;
    private float toNum;//需要设置的金额总数
    private float fromNum = 0;

    private long mDuration = 1500;
    private ValueAnimator mAnimator;

    private DecimalFormat mDecimalFormat;

    public RiseNumberTextView(Context context) {
        super(context);
    }

    public RiseNumberTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 开始动画
     */
    public void startAnimation() {
        mAnimator = ValueAnimator.ofFloat(fromNum, toNum);
        mAnimator.setDuration(mDuration);
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                setCustonText(animation);
            }
        });
        mAnimator.start();
    }

    /**
     * @param animation
     */
    private void setCustonText(ValueAnimator animation) {
        if (animation.getAnimatedFraction() <= 1) {
            setText(mDecimalFormat.format(Float.parseFloat(animation.getAnimatedValue().toString())));
        } else {
            mPlayingState = STOPPED;
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mDecimalFormat = new DecimalFormat("##0.00");
    }

    /**
     *  传递一个数据进来
     * @param number
     * @return
     */
    public RiseNumberTextView withNumber(float number) {
        this.toNum = number;
        fromNum = number / 10;
        return this;
    }

    /**
     *  判断是否在运行
     * @return
     */
    private boolean isRunning() {
        return (mPlayingState == RUNNING);
    }

    /**
     * 外部调用的一个方法
     */
    public void start(){
        if (!isRunning()){
            mPlayingState = RUNNING;
            startAnimation();
        }
    }
}
