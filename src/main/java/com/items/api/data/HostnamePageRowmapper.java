package com.items.api.data;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HostnamePageRowmapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        HostnamePage hostnamePage = new HostnamePage();
        hostnamePage.setHostname(rs.getString("hostname"));
        hostnamePage.setTitle(rs.getString("title"));
        hostnamePage.setUrl(rs.getString("url"));
        return hostnamePage;
    }
}
