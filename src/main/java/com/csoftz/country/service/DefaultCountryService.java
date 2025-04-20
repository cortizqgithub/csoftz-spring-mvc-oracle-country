package com.csoftz.country.service;

import com.csoftz.country.data.CountryData;
import com.csoftz.country.domain.Country;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DefaultCountryService implements CountryService {
    private static final Logger logger = LoggerFactory.getLogger(DefaultCountryService.class);

    private final CountryData countryData;

    public DefaultCountryService(CountryData countryData) {
        this.countryData = countryData;
    }

    @Override
    public List<Country> findAll() {
        logger.debug("Fetching all countries");

        return countryData.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        logger.debug("Fetching country with id: {}", id);

        return countryData.findById(id);
    }

    @Override
    public Country save(Country country) {
        logger.debug("Saving country: {}", country);

        return countryData.save(country);
    }

    @Override
    public Country update(Long id, Country country) {
        logger.debug("Updating country with id: {} with data: {}", id, country);

        return countryData.save(country);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("Deleting country with id: {}", id);

        countryData.deleteById(id);
    }
}
