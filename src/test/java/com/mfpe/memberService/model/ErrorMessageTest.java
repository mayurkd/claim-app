package com.mfpe.memberService.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class ErrorMessageTest {
    @Test
    void testConstructor() {
        ErrorMessage actualErrorMessage = new ErrorMessage();
        actualErrorMessage.setDescription("The characteristics of someone or something");
        actualErrorMessage.setMessage("Not all who wander are lost");
        actualErrorMessage.setStatusCode(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualErrorMessage.setTimestamp(fromResult);
        assertEquals("The characteristics of someone or something", actualErrorMessage.getDescription());
        assertEquals("Not all who wander are lost", actualErrorMessage.getMessage());
        assertEquals(1, actualErrorMessage.getStatusCode());
        assertSame(fromResult, actualErrorMessage.getTimestamp());
    }

    @Test
    void testConstructor2() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        ErrorMessage actualErrorMessage = new ErrorMessage(1,
                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), "Not all who wander are lost",
                "The characteristics of someone or something");
        actualErrorMessage.setDescription("The characteristics of someone or something");
        actualErrorMessage.setMessage("Not all who wander are lost");
        actualErrorMessage.setStatusCode(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        actualErrorMessage.setTimestamp(fromResult);
        assertEquals("The characteristics of someone or something", actualErrorMessage.getDescription());
        assertEquals("Not all who wander are lost", actualErrorMessage.getMessage());
        assertEquals(1, actualErrorMessage.getStatusCode());
        assertSame(fromResult, actualErrorMessage.getTimestamp());
    }
}

