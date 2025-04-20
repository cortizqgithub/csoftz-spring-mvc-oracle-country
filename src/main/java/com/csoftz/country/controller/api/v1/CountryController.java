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

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {
    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAllCountries() {
        logger.info("GET /api/v1/countries");

        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        logger.info("GET /api/v1/countries/{}", id);

        Optional<Country> country = countryService.findById(id);
        return country.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Country createCountry(@Valid @RequestBody Country country) {
        logger.info("POST /api/v1/countries with data: {}", country);

        return countryService.save(country);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @Valid @RequestBody Country country) {
        logger.info("PUT /api/v1/countries/{} with data: {}", id, country);

        Optional<Country> optionalCountry = countryService.findById(id);

        if (optionalCountry.isPresent()) {
            return ResponseEntity.ok(countryService.update(id, country));
        }

        return ResponseEntity.notFound().build();
    }

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
