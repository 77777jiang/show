package com.test.pojo;

public class Uegs {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    int id;
    String username;
    String password;
    int sex;

    public int getSex(int sex) {
        return this.sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public void getUsername(String username) {
    }

    public void getPassword(String password) {
    }

    public void getSex(String sex) {
    }

    public int getSex() {
        return sex;
    }
}
