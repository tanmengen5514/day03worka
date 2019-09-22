package com.tan.en.day03workb.presenter;

import com.tan.en.day03workb.bean.FuliBean;
import com.tan.en.day03workb.model.NetModel;
import com.tan.en.day03workb.view.NetView;

import java.util.ArrayList;

/**
 * Created by en on 2019/9/20.
 */

public class NetPresenter implements NetModel.NetCallBack{
    private NetView netView;
    private NetModel netModel;

    public NetPresenter(NetView netView) {
        this.netView = netView;
        this.netModel=new NetModel();
    }

    public void getResults() {
        netModel.getResults(this);
    }

    @Override
    public void setResults(ArrayList<FuliBean.ResultsBean> results) {
        netView.getNewDatas(results);
    }

    @Override
    public void setFail(String s) {
            netView.getFail(s);
    }
}
