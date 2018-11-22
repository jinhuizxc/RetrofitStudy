package com.example.jinhui.retrofitstudy;

/**
 * Email: 1004260403@qq.com
 * Created by jinhui on 2018/11/22.
 */
public class UserInfoModel {

    public int code;
    public UserInfo data;
    public String message;

    public class UserInfo{

        public int id;
        public String username;
        public String email;
        public String tel;

    }
}
