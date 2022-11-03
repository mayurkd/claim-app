package com.mfpe.memberService.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class InvalidMemberIdExceptionTest {
    @Test
    void testConstructor() {
        InvalidMemberIdException actualInvalidMemberIdException = new InvalidMemberIdException("An error occurred");
        assertNull(actualInvalidMemberIdException.getCause());
        assertEquals("com.mfpe.memberService.exceptions.InvalidMemberIdException: An error occurred",
                actualInvalidMemberIdException.toString());
        assertEquals(0, actualInvalidMemberIdException.getSuppressed().length);
        assertEquals("An error occurred", actualInvalidMemberIdException.getMessage());
        assertEquals("An error occurred", actualInvalidMemberIdException.getLocalizedMessage());
    }
}

