package com.tan.en.day03work2.presenter;

import com.tan.en.day03work2.bean.TeacherBean;
import com.tan.en.day03work2.bean.WorkBean;
import com.tan.en.day03work2.model.NetModel;
import com.tan.en.day03work2.view.NetView;

import java.util.ArrayList;

/**
 * Created by en on 2019/9/22.
 */

public class NetPresenter implements NetModel.NetCallBack {

    private NetView netView;
    private NetModel netModel;

    public NetPresenter(NetView netView) {
        this.netView = netView;
        this.netModel = new NetModel();
    }


    @Override
    public void setNetResults(ArrayList<TeacherBean.BodyBean.ResultBean> results) {
        netView.getResults(results);
    }

    @Override
    public void setNetFail(String s) {
        netView.getFail(s);
    }

    public void getNetResults() {
        netModel.getNetResults(this);
    }
}
