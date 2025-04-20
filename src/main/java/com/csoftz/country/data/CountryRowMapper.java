package com.csoftz.country.data;

import com.csoftz.country.domain.Country;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CountryRowMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Country(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("code"),
            rs.getLong("population")
        );
    }
}
