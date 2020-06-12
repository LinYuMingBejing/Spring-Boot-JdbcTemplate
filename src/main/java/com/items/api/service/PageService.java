package com.items.api.service;


import com.items.api.data.HostnamePage;
import com.items.api.data.HostnamePageResponse;
import com.items.api.data.KeywordResponse;
import com.items.api.data.Keywords;
import com.items.api.dao.JdbcPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PageService {
    @Autowired
    private JdbcPageRepository jdbcPageRepository;


    public Map<String, String> getHostnameByUrls(List<String> urls){
        /** 學習小重點：
         * 遍歷List獲取新對象：stream().map().collect(Collectors.toList())
         * map() 加入需要轉換新對象的參數
         */
        List<String> url2 = urls.stream().map(s->
                String.format("***%s***",s)
        ).collect(Collectors.toList());

        /** 學習小重點：
         *  List集合轉Map方法 Collectors.toMap()
         *  當中： -> 屬於 Java的 lambda 函式
         *  第一個參數屬於Key    (u -> u)
         *  第二個參數屬於Value  (u -> {return jdbcPageRepository.findHostnameByUrl(u)})
         *  第三個參數屬於異常處理（如Key 重複，要取哪個Key的value）
         */
        Map<String, String> HostnameMap= urls.stream().collect(Collectors.toMap(u -> u, u -> {
            return jdbcPageRepository.findHostnameByUrl(u);
        }, (u1,u2)->u1));

        /** 學習小重點：
         * HashMap 取出 key 與value
         * values() 與 keySet() 方法
         */
        Collection<String> hostname = HostnameMap.values();
        Collection<String> url = HostnameMap.keySet();

        /** 學習小重點：
         *  練習hashmap方法
         *  forEach()方法: 遍歷元素 (Java 8 新特性)
         *  get(): 取出該key 的 value
         *  put(): 放入 key & value
         */
        Map<String, String> TestMap = new HashMap();
        HostnameMap.forEach((k, v)-> {
            String key = String.format("%s的網域", k);
            String host = String.format("***%s***",HostnameMap.get(k));
            TestMap.put(key, host);
        });
        return HostnameMap;
    }

    public KeywordResponse getKeywordsByHostname(String hostname){
        /** 目標：熟悉不同數據類型的轉換
         *  小練習：HashMap 與 String 之間的轉換
         */
        List<Keywords> keywords =  jdbcPageRepository.findKeywordByHostname(hostname);
        Set<String> keywordSet = new HashSet<>();
        for(Keywords keyword: keywords){
            String words = keyword.getKeywords();
            List<String> word = Arrays.asList(words.split(","));
            for (String w : word){
                keywordSet.add(w);
            }
        }
        KeywordResponse keywordResponse = new KeywordResponse();
        keywordResponse.setKeywords(new ArrayList<>(keywordSet).subList(0,10));
        return keywordResponse;
    }

    public HostnamePageResponse findPageByHostname(String hostname){
        List<HostnamePage> pages = jdbcPageRepository.findTitleByHostname(hostname);
        List<String> titleList = new ArrayList<>();
        for (HostnamePage page:pages){
            titleList.add(page.getTitle());
        }
        HostnamePageResponse hostnamePageResponse= new HostnamePageResponse();
        hostnamePageResponse.setHostname(hostname);
        hostnamePageResponse.setTitle(titleList);
        return hostnamePageResponse;
    }
}
