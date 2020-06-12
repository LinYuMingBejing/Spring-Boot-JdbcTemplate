package com.items.api.data;

import java.util.List;

public class HostnamePageResponse {
    private String hostname;
    private List<String> title;

    public HostnamePageResponse() {
    }

    public HostnamePageResponse(String hostname, List<String> title) {
        this.hostname = hostname;
        this.title = title;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public List<String> getTitle() {
        return title;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }
}
