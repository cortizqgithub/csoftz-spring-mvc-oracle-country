package com.csoftz.country.data;

import com.csoftz.country.domain.Country;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultCountryData implements CountryData {
    private final JdbcTemplate jdbcTemplate;

    public DefaultCountryData(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Country> findAll() {
        return jdbcTemplate.query("SELECT * FROM country", new CountryRowMapper());
    }

    @Override
    public Optional<Country> findById(Long id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM country WHERE id = ?", new CountryRowMapper(), id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Country save(Country country) {
        if (country.id() == null) {
            jdbcTemplate.update("INSERT INTO country (id, name, code, population) VALUES (country_seq.NEXTVAL, ?, ?, ?)", country.name(), country.code(), country.population());
            Long newId = jdbcTemplate.queryForObject("SELECT country_seq.CURRVAL FROM dual", Long.class);
            return new Country(newId, country.name(), country.code(), country.population());
        } else {
            String sql = "UPDATE country SET name = ?, code = ?, population = ? WHERE id = ?";
            jdbcTemplate.update(sql, country.name(), country.code(), country.population(), country.id());
            return country;
        }
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM country WHERE id = ?", id);
    }
}
