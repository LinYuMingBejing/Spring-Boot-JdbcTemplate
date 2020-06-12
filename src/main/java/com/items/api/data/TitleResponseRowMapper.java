package com.items.api.data;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TitleResponseRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        TitleResponse titleResponse = new TitleResponse();
        titleResponse.setTitle(rs.getString("title"));
        titleResponse.setUrl(rs.getString("url"));
        return titleResponse;
    }
}
