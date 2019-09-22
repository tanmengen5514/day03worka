package com.tan.en.day03work2.view;

import com.tan.en.day03work2.bean.TeacherBean;

import java.util.ArrayList;

/**
 * Created by en on 2019/9/22.
 */

public interface NetView {
    void getResults(ArrayList<TeacherBean.BodyBean.ResultBean> resultBeans);
    void getFail(String s);
}
