package com.zhongzi.taomanjia.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2017/12/15.
 * 一个待图片的button
 */

public class DrawableLeftButton extends AppCompatButton{
    public DrawableLeftButton(Context context) {
        super(context);
    }

    public DrawableLeftButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables=getCompoundDrawables();
        if (drawables!=null){
            Drawable drawableLeft=drawables[0];
            int drawableWidth=drawableLeft.getIntrinsicWidth();
            int padding=getCompoundDrawablePadding();
            int textWidth= (int) getPaint().measureText(getText().toString().trim());
            int bodyWidth=drawableWidth+padding+textWidth;
            canvas.save();
            canvas.translate((getWidth()-bodyWidth)/2,0);
        }

        super.onDraw(canvas);
    }
}
