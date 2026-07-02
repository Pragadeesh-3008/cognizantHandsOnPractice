package com.ormlearn.exception;

/**
 * GROUP 1 — Hands-on 6: Find Country by Code
 *
 * Custom runtime exception thrown when a Country with the given code
 * does not exist in the database.
 *
 * WHY RUNTIME EXCEPTION?
 * Spring's @Transactional rolls back transactions only on unchecked
 * (RuntimeException) by default, so we extend RuntimeException.
 *
 * INTERVIEW Q: Why not use a checked exception?
 * A: Checked exceptions would force all callers to handle/declare them,
 *    cluttering service APIs. RuntimeExceptions allow clean propagation
 *    and integrate naturally with Spring's transaction rollback mechanism.
 */
public class CountryNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String countryCode;

    public CountryNotFoundException(String countryCode) {
        super("Country not found with code: " + countryCode);
        this.countryCode = countryCode;
    }

    public CountryNotFoundException(String countryCode, String message) {
        super(message);
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
