package com.zhongzi.taomanjia.view.adapter.product;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.entity.res.ProductTypeItemRes;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.fragment.base.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/12/6.
 */

public class ProductItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ProductTypeItemRes> mProductTypeItemResList;
    private Context mContext;
    private LayoutInflater mInflater;
    private OnProductItemListener mListener;

    public void setListener(OnProductItemListener listener) {
        this.mListener = listener;
    }

    public ProductItemAdapter(Context context, List<ProductTypeItemRes> productTypeItemRes){
        this.mContext=context;
        this.mProductTypeItemResList=productTypeItemRes;
        this.mInflater=LayoutInflater.from(mContext);
    }
//    View view=null;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        int type=getItemViewType(viewType);
        HeaderViewHolder headerViewHolder=null;
        ItemViewHolder itemViewHolder=null;
        if (viewType==BaseConstants.PRODUCT_DATA_HEADER){
            if (headerViewHolder==null){
                View view=mInflater.inflate(R.layout.item_product_type_title,parent,false);
                headerViewHolder=new HeaderViewHolder(view);
            }
            return headerViewHolder;
        }else {
            if (headerViewHolder==null){
                View view=mInflater.inflate(R.layout.item_product_type_gridview,parent,false);
                itemViewHolder=new ItemViewHolder(view);
            }
            return itemViewHolder;
        }
//        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,final int position) {
        final ProductTypeItemRes itemRes=mProductTypeItemResList.get(position);
      if (holder instanceof HeaderViewHolder){
          ((HeaderViewHolder)holder).textView.setText(itemRes.getName());
      }else {
          ((ItemViewHolder)holder).name.setText(itemRes.getName());
          ((ItemViewHolder)holder).img.setImageURI(itemRes.getmCategotyMobilePic());
          ((ItemViewHolder)holder).img.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  mListener.onItemListener(itemRes.getId(),itemRes.getName());
              }
          });
      }
    }

    @Override
    public int getItemCount() {
        return mProductTypeItemResList.size();
    }

    @Override
    public int getItemViewType(int position) {
        ProductTypeItemRes itemRes=mProductTypeItemResList.get(position);
        if (itemRes.getDataType()== BaseConstants.PRODUCT_DATA_HEADER){
            return BaseConstants.PRODUCT_DATA_HEADER;
        }else {
            return BaseConstants.PRODUCT_DATA_ITEM;
        }
    }
    public static class HeaderViewHolder extends RecyclerView.ViewHolder{
        protected TextView textView;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.product_item_title);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        protected TextView name;
        protected SimpleDraweeView img;
        public ItemViewHolder(View itemView) {
            super(itemView);
            img= (SimpleDraweeView) itemView.findViewById(R.id.product_item_grid_img);
            name= (TextView) itemView.findViewById(R.id.product_item_grid_name);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if(manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
//                    LogUtil.e("------"+getItemViewType(position));
                    return getItemViewType(position) == BaseConstants.PRODUCT_DATA_HEADER
                            ? gridManager.getSpanCount() : 1;
                }
            });
        }
    }

    public interface OnProductItemListener{
        void onItemListener(String id,String name);
    }
}
