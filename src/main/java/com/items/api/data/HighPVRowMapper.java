package com.items.api.data;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HighPVRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        HighPV highPV = new HighPV();
        highPV.setTitle(resultSet.getString("title"));
        highPV.setUrl(resultSet.getString("url"));
        highPV.setPv_valid(resultSet.getInt("pv_valid"));
        return highPV;
    }
}
