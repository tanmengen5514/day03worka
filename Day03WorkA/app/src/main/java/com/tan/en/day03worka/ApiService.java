package com.tan.en.day03worka;

import com.tan.en.day03worka.bean.MyBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by en on 2019/9/20.
 */

public interface ApiService {

    String url="http://static.owspace.com/";
    @GET("?c=api&a=getList&page_id=0")
    Observable<MyBean> geturl();
}
