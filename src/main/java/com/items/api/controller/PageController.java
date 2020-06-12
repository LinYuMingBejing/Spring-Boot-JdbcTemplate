package com.items.api.controller;

import com.items.api.data.*;
import com.items.api.dao.JdbcPageRepository;
import com.items.api.service.PageService;
import com.items.api.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class PageController {
    @Autowired
    private JdbcPageRepository jdbcPageRepository;

    @Autowired
    private PageService pageService;

    @ResponseBody
    @GetMapping("/findAll")
    public List<Page> findAll(){
        return jdbcPageRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/url")
    public List<Page> findByUrl(@RequestParam String url){
        return jdbcPageRepository.findByUrl(url);
    }

    @ResponseBody
    @GetMapping("/city")
    public CityCount findByCity(@RequestParam String city){
        return jdbcPageRepository.findByCity(city);
    }

    @ResponseBody
    @GetMapping("/high_pv")
    private List<HighPV> findByHighPV(){
        return jdbcPageRepository.findByHighPV();
    }

    @ResponseBody
    @GetMapping("/title")
    private TitleResponse findTitleByUrl(@RequestParam String url){
        String title =  jdbcPageRepository.findTitleByUrl(url);
        TitleResponse titleResponse = new TitleResponse();
        titleResponse.setTitle(title);
        titleResponse.setTitle(url);
        return titleResponse;
    }

    @ResponseBody
    @GetMapping("/date")
    private List<LocalDate> getInterval(@RequestParam @DateTimeFormat(pattern="yyyyMMdd") LocalDate startDate, @RequestParam @DateTimeFormat(pattern="yyyyMMdd") LocalDate endDate){
        List<LocalDate> dates = Tool.getDatesBetween(startDate, endDate);
        List<Object> num = dates.stream().map(s->s.getDayOfWeek().getValue()).filter(s->s!=2).limit(3).sorted().collect(Collectors.toList());
        List<LocalDate> dates2 = new ArrayList();
        for(LocalDate date : dates){
            if (date.getDayOfWeek().getValue() !=2){
                dates2.add(date);
            }
        }
        Collections.sort(dates2);
        return Tool.getDatesBetween(startDate, endDate);
    }

    @ResponseBody
    @GetMapping("/table")
    private boolean checkTableExist(@RequestParam  String tableName) throws SQLException {
        return jdbcPageRepository.checkTableExist(tableName);
    }


    @ResponseBody
    @GetMapping("/top/pages")
    private List<TitleResponse> findPageByHighPV(){
        return jdbcPageRepository.findPageByHighPV();
    }

    @ResponseBody
    @GetMapping("/url/hostname")
    private  Map<String, String> mapTest(@RequestParam List<String> urls){
        return pageService.getHostnameByUrls(urls);
    }

    @ResponseBody
    @GetMapping("/keyword/hostname")
    private KeywordResponse getKeyword(@RequestParam String hostname){
        return pageService.getKeywordsByHostname(hostname);
    }

    @ResponseBody
    @GetMapping("/hostname/title")
    private HostnamePageResponse getPageByHostname(@RequestParam String hostname){
        return pageService.findPageByHostname(hostname);
    }
}
