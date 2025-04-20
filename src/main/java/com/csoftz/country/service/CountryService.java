package com.csoftz.country.service;

import com.csoftz.country.domain.Country;
import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);

    Country save(Country country);

    Country update(Long id, Country country);

    void deleteById(Long id);
}
