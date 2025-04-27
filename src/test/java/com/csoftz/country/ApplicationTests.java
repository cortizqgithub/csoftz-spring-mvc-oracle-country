/*----------------------------------------------------------------------------*/
/* Source File:   APPLICATIONTESTS.JAVA                                       */
/* Copyright (c), 2025 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Apr.19/2025  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.country;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * Unit tests for Application class.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@SpringBootTest
class ApplicationTests {
    @Autowired
    ApplicationContext appContext;

    /**
     * Validates the Spring Boot context is loaded.
     */
    @Test
    void contextLoads() {
        assertThat(appContext).isNotNull();
    }

}
