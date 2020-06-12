package com.items.api.dao;

import com.items.api.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcPageRepository implements PageRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /** JdbcTemplate 數據獲取之練習:
     *  直接 new 對象();
     */
    @Override
    public List<Page> findAll() {
        return jdbcTemplate.query(
                "select * from page_location_device_system_pv_20200608 limit 100",
                (rs, rowNum) ->
                        new Page(rs.getLong("id"),
                                rs.getString("city"),
                                rs.getString("country_short"),
                                rs.getString("device_type"),
                                rs.getString("keywords"),
                                rs.getString("hostname"),
                                rs.getInt("pv_valid"),
                                rs.getString("title"),
                                rs.getString("url"))
        );
    }

    /**
     * JdbcTemplate 數據獲取之練習:
     *  透過RowMapper封裝自定義數據格式
     */
    @Override
    public List<Page> findByUrl(String url) {
        return jdbcTemplate.query("select * from article_pv where url = ?", new Object[] {url}, new BeanPropertyRowMapper<Page>(Page.class));
    }

    /** 練習：queryForObject: 獲取非list數據形態
     *
     */
    @Override
    public CityCount findByCity(String city) {
        return (CityCount) jdbcTemplate.queryForObject("SELECT city, sum(pv_valid) as pv_valid FROM demo.article_pv where city = ? group by city", new Object[]{city}, new CityRowMapper());
    }

    @Override
    public List<HighPV> findByHighPV() {
        return (List<HighPV>) jdbcTemplate.query("select title, url, sum(pv_valid) as pv_valid FROM demo.article_pv group by page_id, title, url order by pv_valid desc limit 100", new Object[]{}, new HighPVRowMapper());
    }

    @Override
    public String findTitleByUrl(String url) {
        return jdbcTemplate.queryForObject("select title from demo.article_pv where url = ? group by title", new Object[]{url}, String.class);
    }

    @Override
    public List<TitleResponse> findPageByHighPV() {
        return (List<TitleResponse>) jdbcTemplate.query("select title, url from demo.article_pv group by title, url order by sum(pv_valid) desc", new Object[]{}, new TitleResponseRowMapper());
    }

    @Override
    public String findHostnameByUrl(String url) {
        return jdbcTemplate.queryForObject("select hostname from demo.article_pv where url = ? group by hostname", new Object[]{url}, String.class);
    }

    @Override
    public List<Keywords> findKeywordByHostname(String hostname) {
        return jdbcTemplate.query("select keywords, hostname from demo.article_pv where hostname=?", new Object[]{hostname},new KeywordsRowMapper());
    }

    @Override
    public List<HostnamePage> findTitleByHostname(String hostname) {
        return jdbcTemplate.query("select hostname, title, url from demo.article_pv where hostname=? group by hostname, title, url ",new Object[]{hostname}, new HostnamePageRowmapper());
    }

    /** 練習 :
     * 判斷table是否存在
     */
    public boolean checkTableExist(String tableName) throws SQLException {
        DataSource dataSource = this.jdbcTemplate.getDataSource();
        Connection connection = null;
        try{
            connection = dataSource.getConnection();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet tables = databaseMetaData.getTables(null, null, tableName, null);
            if (tables.next()){
                return true;
            }
            return false;
        }
        finally {
            if (connection != null){
                try{
                    connection.close();
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }

}
