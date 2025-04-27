/*----------------------------------------------------------------------------*/
/* Source File:   COUNTRYNOTFOUNDEXCEPTION.JAVA                               */
/* Copyright (c), 2025 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Apr.19/2025  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.country.common.exception;

/**
 * Exception thrown when a requested country is not found.
 * <br/><br/>
 * This exception is used to indicate that a specific country,
 * which is being searched for or referenced, is not present or
 * cannot be located in the context of the application.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
public class CountryNotFoundException extends Exception {
    public CountryNotFoundException(String s) {
    }
}
