/*----------------------------------------------------------------------------*/
/* Source File:   COUNTRYROWMAPPER.JAVA                                       */
/* Copyright (c), 2025 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Apr.19/2025  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.country.data;

import com.csoftz.country.domain.Country;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * A RowMapper implementation for mapping rows of a SQL {@link ResultSet}
 * to instances of the {@link Country} (using fields defined here) class.
 * <p>
 * Typically used in conjunction with Spring's {@link JdbcTemplate} to simplify the mapping
 * of database query results to domain objects.
 *
 * @see RowMapper
 * @see ResultSet
 * @see JdbcTemplate
 * @see Country
 */
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
