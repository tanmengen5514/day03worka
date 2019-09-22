package com.tan.en.day03workb.view;

import com.tan.en.day03workb.bean.FuliBean;

import java.util.ArrayList;

/**
 * Created by en on 2019/9/20.
 */

public interface NetView {
    void getNewDatas(ArrayList<FuliBean.ResultsBean> resultsBeans);
    void getFail(String s);
}
