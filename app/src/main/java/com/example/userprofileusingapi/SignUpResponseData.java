package com.example.userprofileusingapi;

import com.google.gson.annotations.SerializedName;

public class SignUpResponseData {

    @SerializedName("id")
    String id;
    @SerializedName("token")
    String token;
    @SerializedName("error")
    String error;

    public SignUpResponseData(String id, String token, String error) {
        this.id = id;
        this.token = token;
        this.error = error;
    }

    @Override
    public String toString() {
        return "SignUpResponseData{" +
                "id='" + id + '\'' +
                ", token='" + token + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
