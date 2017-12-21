package com.zhongzi.taomanjia.view.fragment.bankcard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.view.fragment.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/11/29.
 */

public class BankcardFragmnet extends BaseFragment {

//    @BindView(R.id.bankcard_bankno)
    TextView bankcardBankno;
//    @BindView(R.id.bankcard_useraccount)
    TextView bankcardUseraccount;
//    @BindView(R.id.bankcard_bankname)
    TextView bankcardBankname;
//    @BindView(R.id.bankcard_usertypestr)
    TextView bankcardUsertypestr;
//    @BindView(R.id.bankcard_userstatusstr)
    TextView bankcardUserstatusstr;

//    private static BankcardFragmnet fragment;

    public static BankcardFragmnet newInstance(int key) {

        Bundle args = new Bundle();
        args.putInt("key", key);
        BankcardFragmnet fragment = new BankcardFragmnet();
        fragment.setArguments(args);
        return fragment;
    }

    private int flog = 0;
    @Override
    public void setArguments(Bundle args) {
        flog=args.getInt("key");
    }

    @Override
    protected int setContentLayout() {
        return R.layout.fragment_bankcard;
    }

    @Override
    protected void initView() {
        bankcardBankno= (TextView) findViewById(R.id.bankcard_bankno);
        bankcardUseraccount= (TextView) findViewById(R.id.bankcard_useraccount);
        bankcardBankname= (TextView) findViewById(R.id.bankcard_bankname);
        bankcardUsertypestr= (TextView) findViewById(R.id.bankcard_usertypestr);
        bankcardUserstatusstr= (TextView) findViewById(R.id.bankcard_userstatusstr);
        bankcardUseraccount.setText("第"+flog+"页");
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }
}
