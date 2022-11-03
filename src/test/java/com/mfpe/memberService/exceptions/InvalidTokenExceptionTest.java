package com.mfpe.memberService.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class InvalidTokenExceptionTest {
    @Test
    void testConstructor() {
        InvalidTokenException actualInvalidTokenException = new InvalidTokenException("An error occurred");
        assertNull(actualInvalidTokenException.getCause());
        assertEquals("com.mfpe.memberService.exceptions.InvalidTokenException: An error occurred",
                actualInvalidTokenException.toString());
        assertEquals(0, actualInvalidTokenException.getSuppressed().length);
        assertEquals("An error occurred", actualInvalidTokenException.getMessage());
        assertEquals("An error occurred", actualInvalidTokenException.getLocalizedMessage());
    }
}

