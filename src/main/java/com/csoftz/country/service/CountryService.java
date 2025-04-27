/*----------------------------------------------------------------------------*/
/* Source File:   COUNTRYSERVICE.JAVA                                         */
/* Copyright (c), 2025 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Apr.19/2025  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.country.service;

import com.csoftz.country.domain.Country;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Country entities.
 * <p>
 * Provides core business operations for handling country data.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 * @see Country
 */
public interface CountryService {
    /**
     * Retrieves all countries stored in the system.
     *
     * @return A list of all countries, or an empty list if none exist.
     * @see Country
     */
    List<Country> findAll();

    /**
     * Finds a specific country by its unique identifier.
     *
     * @param id Identifies the unique identifier of the country to find.
     * @return An {@link Optional} containing the found country, or empty if not found.
     * @see Country
     * @see Optional
     */
    Optional<Country> findById(Long id);

    /**
     * Persists a new country record in the system.
     *
     * @param country Uses the {@link Country} entity to be saved.
     * @return The saved {@link Country} instance with its identifier and persisted details.
     * @see Country
     */
    Country save(Country country);

    /**
     * Updates an existing country record with new information.
     *
     * @param id      Indicates the unique identifier of the {@link Country} to update.
     * @param country Uses the {@link Country} entity to be updated.
     * @return The updated {@link Country} instance with its identifier and persisted details.
     * @see Country
     */
    Country update(Long id, Country country);

    /**
     * Removes a country record from the system.
     *
     * @param id Indicates the unique identifier of the {@link Country} to be deleted.
     * @see Country
     */
    void deleteById(Long id);
}
