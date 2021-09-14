package com.example.userprofileusingapi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {

    String baseURL = "https://reqres.in";

    @GET("/api/users?page=1")
    Call<ApiResponse<Users>> getUsers();

    @POST("/api/login")
    Call<LogInUserResponse> getLogInResponse(@Body LogInUserData logInUserData);

    @POST("/api/register")
    Call<SignUpResponseData> getSignUpResponse(@Body SignUpRequestData requestData);


}
