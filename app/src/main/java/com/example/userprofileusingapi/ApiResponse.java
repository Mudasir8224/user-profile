package com.example.userprofileusingapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse<T> {

    @SerializedName("data")
    List<T> usersDataList;

    public ApiResponse(List<T> usersDataList) {
        this.usersDataList = usersDataList;
    }

    public List<T> getUsersDataList() {
        return usersDataList;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "usersDataList=" + usersDataList +
                '}';
    }
}
