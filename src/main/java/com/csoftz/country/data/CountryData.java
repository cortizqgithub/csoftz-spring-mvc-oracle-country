package com.csoftz.country.data;

import com.csoftz.country.domain.Country;
import java.util.List;
import java.util.Optional;

public interface CountryData {
    List<Country> findAll();

    Optional<Country> findById(Long id);

    Country save(Country country);

    void deleteById(Long id);
}
