package com.items.api.data;

public class CityCount {
    private String city;
    private int pv_valid;

    public CityCount() {
    }

    public CityCount(String city, int pv_valid) {
        this.city = city;
        this.pv_valid = pv_valid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPv_valid() {
        return pv_valid;
    }

    public void setPv_valid(int pv_valid) {
        this.pv_valid = pv_valid;
    }
}
