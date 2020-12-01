package com.example.minicompany.interfaces;

import com.example.minicompany.models.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostEndPoint {

    @POST("signup")
    Call<UserModel> newPost(@Body UserModel model);
}
