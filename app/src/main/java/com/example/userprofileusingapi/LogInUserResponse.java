package com.example.userprofileusingapi;

import com.google.gson.annotations.SerializedName;

public class LogInUserResponse {

    @SerializedName("token")
    String token;

    @SerializedName("error")
    String error;

    public LogInUserResponse(String token, String error) {
        this.token = token;
        this.error = error;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "LogInUserResponse{" +
                "token='" + token + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
