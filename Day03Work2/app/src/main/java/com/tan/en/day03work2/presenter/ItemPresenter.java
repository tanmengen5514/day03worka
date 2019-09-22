package com.tan.en.day03work2.presenter;

import com.tan.en.day03work2.bean.WorkBean;
import com.tan.en.day03work2.model.ItemModel;
import com.tan.en.day03work2.view.ItemView;

import java.util.ArrayList;

/**
 * Created by en on 2019/9/22.
 */

public class ItemPresenter implements ItemModel.ItemCallBack {
    private ItemView itemView;
    private ItemModel itemModel;

    public ItemPresenter(ItemView itemView) {
        this.itemView = itemView;
        this.itemModel = new ItemModel();
    }

    @Override
    public void getItemResults(WorkBean.BodyBean resultBeans) {
        itemView.setItemResult(resultBeans);
    }

    @Override
    public void getItemFail(String s) {
        itemView.setItemFail(s);
    }

    public void setItemResults(int mid) {
        itemModel.setItemResults(this,mid);
    }
}
