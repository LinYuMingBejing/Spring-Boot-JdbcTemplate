package com.items.api.data;

public class HostnamePage {
    private String hostname;
    private String title;
    private String url;

    public HostnamePage() {
    }

    public HostnamePage(String hostname, String title, String url) {
        this.hostname = hostname;
        this.title = title;
        this.url = url;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
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
}
