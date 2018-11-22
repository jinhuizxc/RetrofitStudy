package com.example.jinhui.retrofitstudy;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Email: 1004260403@qq.com
 * Created by jinhui on 2018/11/22.
 */
public interface UserMgrService {


    @GET("login")
    Call<UserInfoModel> login(@Query("username") String username,
                              @Query("pwd") String pwd);

}
