/*----------------------------------------------------------------------------*/
/* Source File:   COUNTRYDATA.JAVA                                            */
/* Copyright (c), 2025 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Apr.19/2025  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.country.data;

import com.csoftz.country.domain.Country;
import java.util.List;
import java.util.Optional;

/**
 * Interface for managing CRUD (Create, Read, Update, and Delete) operations
 * involving {@link Country} entities.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 * @see Country
 */
public interface CountryData {
    /**
     * Retrieves all countries stored in the data source.
     *
     * @return A list of {@link Country} objects representing all countries,
     * or an empty list if no countries are available.
     */
    List<Country> findAll();

    /**
     * Finds a country by its unique identifier.
     *
     * @param id Indicates the unique identifier of the country to be retrieved
     * @return An {@link Optional} containing the {@link Country} if found, or an empty {@link Optional} if not found.
     */
    Optional<Country> findById(Long id);

    /**
     * Persists a {@link Country} entity into the data source. If the country has a
     * null identifier, a new entry is created, and the identifier is assigned. If the
     * country already has an identifier, the existing entry is updated.
     *
     * @param country Uses the {@link Country} entity to be saved or updated
     * @return The saved {@link Country} instance with its identifier and persisted details
     */
    Country save(Country country);

    /**
     * Deletes a country record identified by its unique identifier.
     *
     * @param id Indicates which is the unique identifier of the {@link Country} to be deleted.
     */
    void deleteById(Long id);
}
