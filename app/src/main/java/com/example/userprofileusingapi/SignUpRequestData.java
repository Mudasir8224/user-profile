package com.example.userprofileusingapi;

import com.google.gson.annotations.SerializedName;

public class SignUpRequestData {

    @SerializedName("email")
    String email;
    @SerializedName("password")
    String password;

    public SignUpRequestData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "SignUpRequestData{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
