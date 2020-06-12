package com.items.api.data;

public class Page {
    private long id;
    private String city;
    private String country_short;
    private String device_type;
    private String keywords;
    private String hostname;
    private int pv_valid;
    private String title;
    private String url;

    public Page(long id, String city, String country_short, String device_type, String keywords, String hostname, int pv_valid, String title, String url) {
        this.id = id;
        this.city = city;
        this.country_short = country_short;
        this.device_type = device_type;
        this.keywords = keywords;
        this.hostname = hostname;
        this.pv_valid = pv_valid;
        this.title = title;
        this.url = url;
    }

    public Page() {
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPv_valid() {
        return pv_valid;
    }

    public void setPv_valid(int pv_valid) {
        this.pv_valid = pv_valid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry_short() {
        return country_short;
    }

    public void setCountry_short(String country_short) {
        this.country_short = country_short;
    }
}
