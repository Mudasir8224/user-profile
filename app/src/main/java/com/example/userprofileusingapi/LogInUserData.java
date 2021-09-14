package com.example.userprofileusingapi;

import com.google.gson.annotations.SerializedName;

public class LogInUserData {

    @SerializedName("email")
    String email;

    @SerializedName("password")
    String password;

    public LogInUserData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LogInUserData{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
