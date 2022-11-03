package com.mfpe.memberService.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidatingDTOTest {
    @Test
    void testConstructor() {
        ValidatingDTO actualValidatingDTO = new ValidatingDTO();
        actualValidatingDTO.setValidStatus(true);
        assertTrue(actualValidatingDTO.isValidStatus());
        assertEquals("ValidatingDTO(validStatus=true)", actualValidatingDTO.toString());
    }

    @Test
    void testConstructor2() {
        ValidatingDTO actualValidatingDTO = new ValidatingDTO(true);
        actualValidatingDTO.setValidStatus(true);
        assertTrue(actualValidatingDTO.isValidStatus());
        assertEquals("ValidatingDTO(validStatus=true)", actualValidatingDTO.toString());
    }
}

