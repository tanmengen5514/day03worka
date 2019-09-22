package com.tan.en.day03work2.view;

import com.tan.en.day03work2.bean.WorkBean;

import java.util.ArrayList;

/**
 * Created by en on 2019/9/22.
 */

public interface ItemView {
    void setItemResult(WorkBean.BodyBean result);
    void setItemFail(String s);
}
