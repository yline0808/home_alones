package com.example.maintest;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserItem implements Serializable {
    String id;              //id
    String password;        //비번

    String sex;             //성별
    int age;                //나이
    String live;            //거주지
    String commut;          //통근

    String hlive;           //어디살고
    int place;              //희망평수
    String hfacilities;     //편의시설

    public UserItem() {
    }

    public UserItem(String id) {
        this.id = id;
    }

    public UserItem(String id, String password, String sex, int age, String live, String commut, String hlive, int place, String hfacilities) {
        this.id = id;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.live = live;
        this.commut = commut;
        this.hlive = hlive;
        this.place = place;
        this.hfacilities = hfacilities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public String getCommut() {
        return commut;
    }

    public void setCommut(String commut) {
        this.commut = commut;
    }

    public String getHlive() {
        return hlive;
    }

    public void setHlive(String hlive) {
        this.hlive = hlive;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public String getHfacilities() {
        return hfacilities;
    }

    public void setHfacilities(String hfacilities) {
        this.hfacilities = hfacilities;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", live='" + live + '\'' +
                ", commut='" + commut + '\'' +
                ", hlive='" + hlive + '\'' +
                ", place=" + place +
                ", hfacilities='" + hfacilities + '\'' +
                '}';
    }

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();

        result.put("id", id);
        result.put("password", password);
        result.put("sex", sex);
        result.put("age", age);
        result.put("live", live);
        result.put("commut", commut);
        result.put("hlive", hlive);
        result.put("place", place);
        result.put("hfacilities", hfacilities);

        return result;
    }
}
