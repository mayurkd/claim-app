package com.mfpe.memberService.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ClaimDetailsTest {
    @Test
    void testCanEqual() {
        assertFalse((new ClaimDetails("42", "Status", "The characteristics of someone or something", "Remarks", 10.0, "42",
                "42", "42", "42")).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        ClaimDetails claimDetails = new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42");
        assertTrue(claimDetails.canEqual(new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42")));
    }

    @Test
    void testConstructor() {
        ClaimDetails actualClaimDetails = new ClaimDetails();
        actualClaimDetails.setBenefitId("42");
        actualClaimDetails.setClaimAmount(10.0);
        actualClaimDetails.setClaimId("42");
        actualClaimDetails.setDescription("The characteristics of someone or something");
        actualClaimDetails.setHospitalId("42");
        actualClaimDetails.setMemberId("42");
        actualClaimDetails.setPolicyId("42");
        actualClaimDetails.setRemarks("Remarks");
        actualClaimDetails.setStatus("Status");
        assertEquals("42", actualClaimDetails.getBenefitId());
        assertEquals(10.0, actualClaimDetails.getClaimAmount());
        assertEquals("42", actualClaimDetails.getClaimId());
        assertEquals("The characteristics of someone or something", actualClaimDetails.getDescription());
        assertEquals("42", actualClaimDetails.getHospitalId());
        assertEquals("42", actualClaimDetails.getMemberId());
        assertEquals("42", actualClaimDetails.getPolicyId());
        assertEquals("Remarks", actualClaimDetails.getRemarks());
        assertEquals("Status", actualClaimDetails.getStatus());
        assertEquals(
                "ClaimDetails(claimId=42, status=Status, description=The characteristics of someone or something,"
                        + " remarks=Remarks, claimAmount=10.0, hospitalId=42, benefitId=42, policyId=42, memberId=42)",
                actualClaimDetails.toString());
    }

    @Test
    void testConstructor2() {
        ClaimDetails actualClaimDetails = new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42");

        assertEquals("42", actualClaimDetails.getBenefitId());
        assertEquals("Status", actualClaimDetails.getStatus());
        assertEquals("Remarks", actualClaimDetails.getRemarks());
        assertEquals("42", actualClaimDetails.getPolicyId());
        assertEquals("42", actualClaimDetails.getMemberId());
        assertEquals("42", actualClaimDetails.getHospitalId());
        assertEquals("The characteristics of someone or something", actualClaimDetails.getDescription());
        assertEquals("42", actualClaimDetails.getClaimId());
        assertEquals(10.0, actualClaimDetails.getClaimAmount());
    }

    @Test
    void testEquals() {
        assertFalse((new ClaimDetails("42", "Status", "The characteristics of someone or something", "Remarks", 10.0, "42",
                "42", "42", "42")).equals(null));
        assertFalse((new ClaimDetails("42", "Status", "The characteristics of someone or something", "Remarks", 10.0, "42",
                "42", "42", "42")).equals("Different type to ClaimDetails"));
    }

    @Test
    void testEquals2() {
        ClaimDetails claimDetails = new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42");
        assertTrue(claimDetails.equals(claimDetails));
        int expectedHashCodeResult = claimDetails.hashCode();
        assertEquals(expectedHashCodeResult, claimDetails.hashCode());
    }

    @Test
    void testEquals3() {
        ClaimDetails claimDetails = new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42");
        ClaimDetails claimDetails1 = new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42");

        assertTrue(claimDetails.equals(claimDetails1));
        int expectedHashCodeResult = claimDetails.hashCode();
        assertEquals(expectedHashCodeResult, claimDetails1.hashCode());
    }

    @Test
    void testEquals4() {
        ClaimDetails claimDetails = new ClaimDetails("Status", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42");
        assertFalse(claimDetails.equals(new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals5() {
        ClaimDetails claimDetails = new ClaimDetails(null, "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42");
        assertFalse(claimDetails.equals(new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals6() {
        ClaimDetails claimDetails = new ClaimDetails("42", "42", "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42");
        assertFalse(claimDetails.equals(new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals7() {
        ClaimDetails claimDetails = new ClaimDetails("42", null, "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42");
        assertFalse(claimDetails.equals(new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals8() {
        ClaimDetails claimDetails = new ClaimDetails("42", "Status", "42", "Remarks", 10.0, "42", "42", "42", "42");
        assertFalse(claimDetails.equals(new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals9() {
        ClaimDetails claimDetails = new ClaimDetails("42", "Status", null, "Remarks", 10.0, "42", "42", "42", "42");
        assertFalse(claimDetails.equals(new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals10() {
        ClaimDetails claimDetails = new ClaimDetails("42", "Status", "The characteristics of someone or something", "42",
                10.0, "42", "42", "42", "42");
        assertFalse(claimDetails.equals(new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals11() {
        ClaimDetails claimDetails = new ClaimDetails("42", "Status", "The characteristics of someone or something", null,
                10.0, "42", "42", "42", "42");
        assertFalse(claimDetails.equals(new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals12() {
        ClaimDetails claimDetails = new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 0.5, "42", "42", "42", "42");
        assertFalse(claimDetails.equals(new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals13() {
        ClaimDetails claimDetails = new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "Status", "42", "42", "42");
        assertFalse(claimDetails.equals(new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals14() {
        ClaimDetails claimDetails = new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, null, "42", "42", "42");
        assertFalse(claimDetails.equals(new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals15() {
        ClaimDetails claimDetails = new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "Status", "42", "42");
        assertFalse(claimDetails.equals(new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals16() {
        ClaimDetails claimDetails = new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", null, "42", "42");
        assertFalse(claimDetails.equals(new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals17() {
        ClaimDetails claimDetails = new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "Status", "42");
        assertFalse(claimDetails.equals(new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals18() {
        ClaimDetails claimDetails = new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", null, "42");
        assertFalse(claimDetails.equals(new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals19() {
        ClaimDetails claimDetails = new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "Status");
        assertFalse(claimDetails.equals(new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals20() {
        ClaimDetails claimDetails = new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", null);
        assertFalse(claimDetails.equals(new ClaimDetails("42", "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42")));
    }

    @Test
    void testEquals21() {
        ClaimDetails claimDetails = new ClaimDetails(null, "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42");
        ClaimDetails claimDetails1 = new ClaimDetails(null, "Status", "The characteristics of someone or something",
                "Remarks", 10.0, "42", "42", "42", "42");

        assertTrue(claimDetails.equals(claimDetails1));
        int expectedHashCodeResult = claimDetails.hashCode();
        assertEquals(expectedHashCodeResult, claimDetails1.hashCode());
    }

    @Test
    void testEquals22() {
        ClaimDetails claimDetails = new ClaimDetails("42", null, "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42");
        ClaimDetails claimDetails1 = new ClaimDetails("42", null, "The characteristics of someone or something", "Remarks",
                10.0, "42", "42", "42", "42");

        assertTrue(claimDetails.equals(claimDetails1));
        int expectedHashCodeResult = claimDetails.hashCode();
        assertEquals(expectedHashCodeResult, claimDetails1.hashCode());
    }

    @Test
    void testEquals23() {
        ClaimDetails claimDetails = new ClaimDetails("42", "Status", null, "Remarks", 10.0, "42", "42", "42", "42");
        ClaimDetails claimDetails1 = new ClaimDetails("42", "Status", null, "Remarks", 10.0, "42", "42", "42", "42");

        assertTrue(claimDetails.equals(claimDetails1));
        int expectedHashCodeResult = claimDetails.hashCode();
        assertEquals(expectedHashCodeResult, claimDetails1.hashCode());
    }
}

