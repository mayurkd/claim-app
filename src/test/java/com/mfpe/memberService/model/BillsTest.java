package com.mfpe.memberService.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.sql.Date;

import org.junit.jupiter.api.Test;

class BillsTest {
    @Test
    void testConstructor() {
        Bills actualBills = new Bills();
        actualBills.setDueAmount(1);
        actualBills.setDueDate(mock(Date.class));
        actualBills.setLastPaidDate(mock(Date.class));
        actualBills.setLateCharge(1);
        actualBills.setMemberId("42");
        actualBills.setPolicyId("42");
        assertEquals(1, actualBills.getDueAmount());
        assertEquals(1, actualBills.getLateCharge());
        assertEquals("42", actualBills.getMemberId());
        assertEquals("42", actualBills.getPolicyId());
    }

    @Test
    void testConstructor2() {
        Bills actualBills = new Bills("42", "42", mock(Date.class), 1, 1, mock(Date.class));
        actualBills.setDueAmount(1);
        actualBills.setDueDate(mock(Date.class));
        actualBills.setLastPaidDate(mock(Date.class));
        actualBills.setLateCharge(1);
        actualBills.setMemberId("42");
        actualBills.setPolicyId("42");
        assertEquals(1, actualBills.getDueAmount());
        assertEquals(1, actualBills.getLateCharge());
        assertEquals("42", actualBills.getMemberId());
        assertEquals("42", actualBills.getPolicyId());
    }
}

