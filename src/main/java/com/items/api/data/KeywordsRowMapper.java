package com.items.api.data;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KeywordsRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Keywords keywords = new Keywords();
        keywords.setHostname(rs.getString("hostname"));
        keywords.setKeywords(rs.getString("keywords"));
        return keywords;
    }
}
