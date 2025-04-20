package com.csoftz.country.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record Country(Long id,
                      @NotNull(message = "Name is required")
                      @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
                      String name,
                      @NotNull(message = "Code is required")
                      @Size(min = 2, max = 3, message = "Code must be 2 or 3 characters")
                      String code,
                      @NotNull(message = "Population is required")
                      @Min(value = 0, message = "Population must be non-negative")
                      Long population) {
}
