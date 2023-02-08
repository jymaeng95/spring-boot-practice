package com.lab.java.zayson.item50;

public class MutableAddress {
    // 가변 객체
    private String city;
    private int zipcode;

    public MutableAddress(String city, int zipcode) {
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
