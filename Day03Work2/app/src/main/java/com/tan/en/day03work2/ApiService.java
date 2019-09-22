package com.tan.en.day03work2;

import com.tan.en.day03work2.bean.TeacherBean;
import com.tan.en.day03work2.bean.WorkBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by en on 2019/9/22.
 */

public interface ApiService {
    String teacher_url="https://api.yunxuekeji.cn/";
    @GET("yunxue_app_api/content/getData/30/66597/1/10")
    Observable<TeacherBean> getTeacher();

    String work_url="https://api.yunxuekeji.cn/";
    @GET("yunxue_app_api/teacher/getTeacherPower/{ID}")
    Observable<WorkBean> getWork(@Path("ID") int path);
}
