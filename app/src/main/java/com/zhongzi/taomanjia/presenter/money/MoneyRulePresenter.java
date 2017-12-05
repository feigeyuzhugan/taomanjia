package com.zhongzi.taomanjia.presenter.money;

import android.content.Context;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iView.IMoneyRuleView;

/**
 * Created by Administrator on 2017/11/30.
 */

public class MoneyRulePresenter extends BasePresenter<IMoneyRuleView> {
    private static final String TAG = MoneyRulePresenter.class.getSimpleName();
    String title;
    String content;
    public MoneyRulePresenter(IMoneyRuleView iMoneyRuleView){
        super(iMoneyRuleView);
    }

    public void getMessage(int type, Context context){
        switch (type){
            case BaseConstants.MONEY_CASH://现金
                title=context.getResources().getString( R.string.user_text_case);
                content=context.getResources().getString( R.string.user_text_case_rule);
                mIView.message(title,content);
                break;
            case BaseConstants.MONEY_PENSION://养老
                title=context.getResources().getString( R.string.user_text_pension);
                content=context.getResources().getString( R.string.user_text_pension_rule);
                mIView.message(title,content);
//                mIView.message();
                break;
            case BaseConstants.MONEY_RED_ENVELOPES://红包
                title=context.getResources().getString( R.string.user_text_red_envelope);
                content=context.getResources().getString( R.string.user_text_red_envelope_rule);
                mIView.message(title,content);
//                mIView.message();
                break;
            case BaseConstants.MONEY_SHARED://分享收益
                title=context.getResources().getString( R.string.user_text_case);
                content=context.getResources().getString( R.string.user_text_case_rule);
                mIView.message(title,content);
//                mIView.message();
                break;
            case BaseConstants.MONEY_SPIRIT://盛世金元
                title=context.getResources().getString( R.string.user_text_spirit);
                content=context.getResources().getString( R.string.user_text_spirit_rule);
                mIView.message(title,content);
                break;
        }
    }
}
