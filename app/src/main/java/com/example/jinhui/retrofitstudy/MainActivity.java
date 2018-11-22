package com.example.jinhui.retrofitstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 来自慕课网
 * Retrofit基本使用
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void login(View view) {

        // 创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 获取UserMgrService对象
        UserMgrService userMgrService = retrofit.create(UserMgrService.class);

        // 调用login方法
        final Call<UserInfoModel> call = userMgrService.login("张三", "123456");

        // 发送同步请求
        // 执行会抛出异常NetWorkThreadException，所以需要在子线程中执行
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Response<UserInfoModel> response = null;  // 同步请求
//                try {
//                    response = call.execute();
//                    System.out.println("code = " + response.code());  // 网络响应的code, 请求成功是200， 请求错误是0
//                    assert response.body() != null;
//                    System.out.println("code = " + response.body().code);  // 接口返回的code
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

        // 发送异步请求
        call.enqueue(new Callback<UserInfoModel>() {
            @Override
            public void onResponse(Call<UserInfoModel> call, Response<UserInfoModel> response) {
                if (response.body() != null) {
                    System.out.println("code = " + response.body().data.username);  // 输出用户名
                }
            }

            @Override
            public void onFailure(Call<UserInfoModel> call, Throwable t) {

            }
        });

    }
}
