package com.example.maintest;

import java.io.Serializable;

public class HappyHomeMap implements Serializable {
    int count;              //모집호수_계

    float wd;               //위도
    float gd;               //경도

    float place;            //전용면적_제곱미터

    String supply;          //공급기관
    String supplyInfo;      //공급정보

    String gu;              //구
    String dangi;           //단지명
    String address;         //주소

    long money_mon;         //월임대료
    long money_contract;    //임대보증금_계약금
    long money_changes;     //잔금
    long money_bo;          //임대보증금_계

    public HappyHomeMap(){}



    public HappyHomeMap(int count, float wd, float gd, float place, String supply, String supplyInfo, String gu, String dangi, String address, long money_mon, long money_contract, long money_changes, long money_bo) {
        this.count = count;
        this.wd = wd;
        this.gd = gd;
        this.place = place;
        this.supply = supply;
        this.supplyInfo = supplyInfo;
        this.gu = gu;
        this.dangi = dangi;
        this.address = address;
        this.money_mon = money_mon;
        this.money_contract = money_contract;
        this.money_changes = money_changes;
        this.money_bo = money_bo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getWd() {
        return wd;
    }

    public void setWd(float wd) {
        this.wd = wd;
    }

    public float getGd() {
        return gd;
    }

    public void setGd(float gd) {
        this.gd = gd;
    }

    public float getPlace() {
        return place;
    }

    public void setPlace(float place) {
        this.place = place;
    }

    public String getSupply() {
        return supply;
    }

    public void setSupply(String supply) {
        this.supply = supply;
    }

    public String getSupplyInfo() {
        return supplyInfo;
    }

    public void setSupplyInfo(String supplyInfo) {
        this.supplyInfo = supplyInfo;
    }

    public String getGu() {
        return gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }

    public String getDangi() {
        return dangi;
    }

    public void setDangi(String dangi) {
        this.dangi = dangi;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getMoney_mon() {
        return money_mon;
    }

    public void setMoney_mon(long money_mon) {
        this.money_mon = money_mon;
    }

    public long getMoney_contract() {
        return money_contract;
    }

    public void setMoney_contract(long money_contract) {
        this.money_contract = money_contract;
    }

    public long getMoney_changes() {
        return money_changes;
    }

    public void setMoney_changes(long money_changes) {
        this.money_changes = money_changes;
    }

    public long getMoney_bo() {
        return money_bo;
    }

    public void setMoney_bo(long money_bo) {
        this.money_bo = money_bo;
    }

    @Override
    public String toString() {
        return "HappyHomeMap{" +
                "count=" + count +
                ", wd=" + wd +
                ", gd=" + gd +
                ", place=" + place +
                ", supply='" + supply + '\'' +
                ", supplyInfo='" + supplyInfo + '\'' +
                ", gu='" + gu + '\'' +
                ", dangi='" + dangi + '\'' +
                ", address='" + address + '\'' +
                ", money_mon=" + money_mon +
                ", money_contract=" + money_contract +
                ", money_changes=" + money_changes +
                ", money_bo=" + money_bo +
                '}';
    }
}
