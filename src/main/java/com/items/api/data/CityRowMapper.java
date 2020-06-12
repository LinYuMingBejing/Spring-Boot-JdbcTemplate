package com.items.api.data;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


// RowMapper可以將數據中的每一行數據封裝成用户自定義的類，實現RowMapper接口覆蓋mapRow方法，在mapRow方法封装對數據的返回處理
public class CityRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        CityCount cityCount = new CityCount();
        cityCount.setCity(rs.getString("city"));
        cityCount.setPv_valid(rs.getInt("pv_valid"));
        return cityCount;
    }
}
