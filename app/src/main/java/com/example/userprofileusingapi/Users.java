package com.example.userprofileusingapi;

import com.google.gson.annotations.SerializedName;

public class Users {


    @SerializedName("id")
    String id;

    @SerializedName("first_name")
    String first_name;

    @SerializedName("last_name")
    String last_name;

    @SerializedName("email")
    String email;
    @SerializedName("avatar")
    String avatar;

    public Users(String id, String first_name, String last_name, String email, String avatar) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatar() {
        return avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}

