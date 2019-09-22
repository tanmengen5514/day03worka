package com.tan.en.day03workb;

import com.tan.en.day03workb.bean.FuliBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by en on 2019/9/20.
 */

public interface ApiService {
    String fuli_url="http://gank.io/api/";
    @GET("data/%E7%A6%8F%E5%88%A9/20/1")
    Observable<FuliBean> getfuli();
}
