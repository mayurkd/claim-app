package com.mfpe.memberService.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class InvalidClaimIdExceptionTest {
    @Test
    void testConstructor() {
        InvalidClaimIdException actualInvalidClaimIdException = new InvalidClaimIdException("An error occurred");
        assertNull(actualInvalidClaimIdException.getCause());
        assertEquals("com.mfpe.memberService.exceptions.InvalidClaimIdException: An error occurred",
                actualInvalidClaimIdException.toString());
        assertEquals(0, actualInvalidClaimIdException.getSuppressed().length);
        assertEquals("An error occurred", actualInvalidClaimIdException.getMessage());
        assertEquals("An error occurred", actualInvalidClaimIdException.getLocalizedMessage());
    }
}

