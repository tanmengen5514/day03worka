package com.tan.en.day03worka.view;

import com.tan.en.day03worka.bean.DatasBean;
import com.tan.en.day03worka.bean.MyBean;

import java.util.ArrayList;

/**
 * Created by en on 2019/9/20.
 */

public interface NetView {
    void getDatas(ArrayList<DatasBean> datasBeans);
    void getFail(String s);
}
