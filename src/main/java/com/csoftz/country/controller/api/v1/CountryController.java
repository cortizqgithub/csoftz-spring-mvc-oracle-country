/*----------------------------------------------------------------------------*/
/* Source File:   COUNTRYCONTROLLER.JAVA                                      */
/* Copyright (c), 2025 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Apr.19/2025  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.country.controller.api.v1;

import com.csoftz.country.domain.Country;
import com.csoftz.country.service.CountryService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing Country resources.
 * Provides endpoints to retrieve, create, update, and delete country data.
 * <p>
 * Uses the {@code /api/v1/countries} base path.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {
    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * Retrieves a list of all available countries.
     * <p>
     * GET /api/v1/countries
     *
     * @return a list of {@link Country} objects representing all countries.
     * @see Country
     */
    @GetMapping
    public List<Country> retrieveAllCountries() {
        logger.info("GET /api/v1/countries");

        return countryService.findAll();
    }

    /**
     * Retrieves the details of a specific country based on its unique identifier.
     * <p>
     * GET /api/v1/countries/{id}.
     *
     * @param id Indicates the unique identifier of the country to be retrieved
     * @return A {@link ResponseEntity} containing the {@link Country} object if found,
     * or a {@link ResponseEntity} with a 404 Not Found status if the country does not exist.
     * @see Country
     * @see ResponseEntity
     */
    @GetMapping("/{id}")
    public ResponseEntity<Country> retrieveCountryById(@PathVariable Long id) {
        logger.info("GET /api/v1/countries/{}", id);

        Optional<Country> country = countryService.findById(id);
        return country
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Creates a new country resource in the system.
     * <p>
     * POST /api/v1/countries
     *
     * @param country The {@link Country} object containing the details to be persisted.
     *                It must be a valid object with all required fields populated.
     * @return The saved {@link Country} instance including its generated identifier
     * and persisted details.
     * @see Country
     */
    @PostMapping
    public Country createCountry(@Valid @RequestBody Country country) {
        logger.info("POST /api/v1/countries with data: {}", country);

        return countryService.save(country);
    }

    /**
     * Updates the information of an existing country identified by its unique ID.
     * This method handles HTTP PUT requests to update the country details. If the country
     * with the specified ID exists, it updates the record and returns the updated entity.
     * Otherwise, it returns a 404 Not Found response.
     * <p>
     * PUT /api/v1/countries/{}
     *
     * @param id      Indicates which is the unique identifier of the {@link Country} to be updated.
     * @param country Uses the {@link Country} object containing the updated details to be applied.
     *                It must be a valid object with all required fields populated.
     * @return A {@link ResponseEntity} containing the updated {@link Country} object if the country exists,
     * or a {@link ResponseEntity} with a 404 Not Found status if the country does not exist.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @Valid @RequestBody Country country) {
        logger.info("PUT /api/v1/countries/{} with data: {}", id, country);

        Optional<Country> optionalCountry = countryService.findById(id);

        if (optionalCountry.isPresent()) {
            return ResponseEntity.ok(countryService.update(id, country));
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * Deletes a country resource identified by its unique ID.
     * <p>
     * If a country with the specified ID exists, it will be removed from the system.
     * Otherwise, a 404 Not Found status will be returned.
     *
     * @param id Indicates which is the unique identifier of the {@link Country} to be deleted.
     * @return A {@link ResponseEntity} with an HTTP 200 OK status if the deletion is successful,
     * or an HTTP 404 Not Found status if the specified country does not exist.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        logger.info("DELETE /api/v1/countries/{}", id);

        if (countryService.findById(id).isPresent()) {
            countryService.deleteById(id);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
