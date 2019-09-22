package com.tan.en.day03worka.presenter;

import com.tan.en.day03worka.bean.DatasBean;
import com.tan.en.day03worka.bean.MyBean;
import com.tan.en.day03worka.model.NetModel;
import com.tan.en.day03worka.view.NetView;

import java.util.ArrayList;

/**
 * Created by en on 2019/9/20.
 */

public class NetPresenter implements NetModel.NetCallBack {
    private NetView netView;
    private NetModel netModel;

    public NetPresenter(NetView netView) {
        this.netView = netView;
        this.netModel = new NetModel();
    }

    public void getDatas() {
        netModel.getDatas(this);
    }

    @Override
    public void getNetDatas(ArrayList<DatasBean> datasBeans) {
        netView.getDatas(datasBeans);
    }

    @Override
    public void getNetFail(String s) {
        netView.getFail(s);
    }
}
