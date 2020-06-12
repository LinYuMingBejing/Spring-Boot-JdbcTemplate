package com.items.api.data;

public class HighPV {

    private String title;
    private String url;
    private int pv_valid;

    public HighPV() {
    }

    public HighPV(String title, String url, int pv_valid) {
        this.title = title;
        this.url = url;
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

    public int getPv_valid() {
        return pv_valid;
    }

    public void setPv_valid(int pv_valid) {
        this.pv_valid = pv_valid;
    }
}
