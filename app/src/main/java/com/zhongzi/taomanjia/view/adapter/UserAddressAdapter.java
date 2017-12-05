package com.zhongzi.taomanjia.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.model.entity.res.address.AddressInfoRes;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 * 地址列表
 */

public class UserAddressAdapter extends RecyclerView.Adapter<UserAddressAdapter.MyViewHolder> {
    private List<AddressInfoRes> mList;
    private UserAddressRemoveListener mRemoveListener;
    private UserAddressEditorListener mEditorListener;
//    private Context mContext;
    private LayoutInflater inflater;

    public void setEditorListener(UserAddressEditorListener editorListener) {
        this.mEditorListener = editorListener;
    }

    public void setRemoveListener(UserAddressRemoveListener removeListener) {
        this.mRemoveListener = removeListener;
    }

    public UserAddressAdapter(List<AddressInfoRes> list,Context context){
        this.mList=list;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.item_address_info,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        AddressInfoRes res=mList.get(position);

        holder.address.setText(res.getConsigneeAddress());
        holder.name.setText(res.getConsignee());
        holder.phone.setText(res.getPhone());
        holder.bianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditorListener.editor(position);
            }
        });
        holder.shanchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRemoveListener.remove(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView phone;
        public TextView address;

        public TextView isdefault;
        public TextView shanchu;
        public TextView bianji;
        public MyViewHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.item_addressinfo_recipient_name);
            phone= (TextView) itemView.findViewById(R.id.item_addressinfo_recipient_phone);
            address=(TextView) itemView.findViewById(R.id.item_addressinfo_recipient_address);

            isdefault=(TextView) itemView.findViewById(R.id.item_addressinfo_isdefault);
            shanchu=(TextView) itemView.findViewById(R.id.item_addressinfo_shanchu);
            bianji=(TextView) itemView.findViewById(R.id.item_addressinfo_bianji);
        }
    }
    public interface UserAddressRemoveListener{
        void remove(int position);
    }
    public interface UserAddressEditorListener{
        void editor(int position);
    }
}
