package com.rafa.pojo;

public class User {
    private int user_id;
    private String user_name;
    private String user_pubKey;

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_pubKey='" + user_pubKey + '\'' +
                '}';
    }
}
