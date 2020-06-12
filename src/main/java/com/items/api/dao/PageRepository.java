package com.items.api.dao;

import com.items.api.data.*;

import java.util.List;

public interface PageRepository {
    List<Page> findAll();
    List<Page> findByUrl(String url);
    CityCount findByCity(String city);
    List<HighPV> findByHighPV();
    String findTitleByUrl(String url);
    List<TitleResponse> findPageByHighPV();
    String findHostnameByUrl(String url);
    List<Keywords> findKeywordByHostname(String hostname);
    List<HostnamePage> findTitleByHostname(String hostname);
}
