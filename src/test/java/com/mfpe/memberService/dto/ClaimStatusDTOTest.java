package com.mfpe.memberService.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ClaimStatusDTOTest {
    @Test
    void testCanEqual() {
        assertFalse((new ClaimStatusDTO("42", "Claim Status", "Claim Description")).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        ClaimStatusDTO claimStatusDTO = new ClaimStatusDTO("42", "Claim Status", "Claim Description");
        assertTrue(claimStatusDTO.canEqual(new ClaimStatusDTO("42", "Claim Status", "Claim Description")));
    }

    @Test
    void testConstructor() {
        ClaimStatusDTO actualClaimStatusDTO = new ClaimStatusDTO();
        actualClaimStatusDTO.setClaimDescription("Claim Description");
        actualClaimStatusDTO.setClaimId("42");
        actualClaimStatusDTO.setClaimStatus("Claim Status");
        assertEquals("Claim Description", actualClaimStatusDTO.getClaimDescription());
        assertEquals("42", actualClaimStatusDTO.getClaimId());
        assertEquals("Claim Status", actualClaimStatusDTO.getClaimStatus());
        assertEquals("ClaimStatusDTO(claimId=42, claimStatus=Claim Status, claimDescription=Claim Description)",
                actualClaimStatusDTO.toString());
    }

    @Test
    void testConstructor2() {
        ClaimStatusDTO actualClaimStatusDTO = new ClaimStatusDTO("42", "Claim Status", "Claim Description");
        actualClaimStatusDTO.setClaimDescription("Claim Description");
        actualClaimStatusDTO.setClaimId("42");
        actualClaimStatusDTO.setClaimStatus("Claim Status");
        assertEquals("Claim Description", actualClaimStatusDTO.getClaimDescription());
        assertEquals("42", actualClaimStatusDTO.getClaimId());
        assertEquals("Claim Status", actualClaimStatusDTO.getClaimStatus());
        assertEquals("ClaimStatusDTO(claimId=42, claimStatus=Claim Status, claimDescription=Claim Description)",
                actualClaimStatusDTO.toString());
    }

    @Test
    void testEquals() {
        assertFalse((new ClaimStatusDTO("42", "Claim Status", "Claim Description")).equals(null));
        assertFalse(
                (new ClaimStatusDTO("42", "Claim Status", "Claim Description")).equals("Different type to ClaimStatusDTO"));
    }

    @Test
    void testEquals2() {
        ClaimStatusDTO claimStatusDTO = new ClaimStatusDTO("42", "Claim Status", "Claim Description");
        assertTrue(claimStatusDTO.equals(claimStatusDTO));
        int expectedHashCodeResult = claimStatusDTO.hashCode();
        assertEquals(expectedHashCodeResult, claimStatusDTO.hashCode());
    }

    @Test
    void testEquals3() {
        ClaimStatusDTO claimStatusDTO = new ClaimStatusDTO("42", "Claim Status", "Claim Description");
        ClaimStatusDTO claimStatusDTO1 = new ClaimStatusDTO("42", "Claim Status", "Claim Description");

        assertTrue(claimStatusDTO.equals(claimStatusDTO1));
        int expectedHashCodeResult = claimStatusDTO.hashCode();
        assertEquals(expectedHashCodeResult, claimStatusDTO1.hashCode());
    }

    @Test
    void testEquals4() {
        ClaimStatusDTO claimStatusDTO = new ClaimStatusDTO("Claim Status", "Claim Status", "Claim Description");
        assertFalse(claimStatusDTO.equals(new ClaimStatusDTO("42", "Claim Status", "Claim Description")));
    }

    @Test
    void testEquals5() {
        ClaimStatusDTO claimStatusDTO = new ClaimStatusDTO(null, "Claim Status", "Claim Description");
        assertFalse(claimStatusDTO.equals(new ClaimStatusDTO("42", "Claim Status", "Claim Description")));
    }

    @Test
    void testEquals6() {
        ClaimStatusDTO claimStatusDTO = new ClaimStatusDTO("42", "42", "Claim Description");
        assertFalse(claimStatusDTO.equals(new ClaimStatusDTO("42", "Claim Status", "Claim Description")));
    }

    @Test
    void testEquals7() {
        ClaimStatusDTO claimStatusDTO = new ClaimStatusDTO("42", null, "Claim Description");
        assertFalse(claimStatusDTO.equals(new ClaimStatusDTO("42", "Claim Status", "Claim Description")));
    }

    @Test
    void testEquals8() {
        ClaimStatusDTO claimStatusDTO = new ClaimStatusDTO("42", "Claim Status", "42");
        assertFalse(claimStatusDTO.equals(new ClaimStatusDTO("42", "Claim Status", "Claim Description")));
    }

    @Test
    void testEquals9() {
        ClaimStatusDTO claimStatusDTO = new ClaimStatusDTO("42", "Claim Status", null);
        assertFalse(claimStatusDTO.equals(new ClaimStatusDTO("42", "Claim Status", "Claim Description")));
    }

    @Test
    void testEquals10() {
        ClaimStatusDTO claimStatusDTO = new ClaimStatusDTO(null, "Claim Status", "Claim Description");
        ClaimStatusDTO claimStatusDTO1 = new ClaimStatusDTO(null, "Claim Status", "Claim Description");

        assertTrue(claimStatusDTO.equals(claimStatusDTO1));
        int expectedHashCodeResult = claimStatusDTO.hashCode();
        assertEquals(expectedHashCodeResult, claimStatusDTO1.hashCode());
    }

    @Test
    void testEquals11() {
        ClaimStatusDTO claimStatusDTO = new ClaimStatusDTO("42", null, "Claim Description");
        ClaimStatusDTO claimStatusDTO1 = new ClaimStatusDTO("42", null, "Claim Description");

        assertTrue(claimStatusDTO.equals(claimStatusDTO1));
        int expectedHashCodeResult = claimStatusDTO.hashCode();
        assertEquals(expectedHashCodeResult, claimStatusDTO1.hashCode());
    }

    @Test
    void testEquals12() {
        ClaimStatusDTO claimStatusDTO = new ClaimStatusDTO("42", "Claim Status", null);
        ClaimStatusDTO claimStatusDTO1 = new ClaimStatusDTO("42", "Claim Status", null);

        assertTrue(claimStatusDTO.equals(claimStatusDTO1));
        int expectedHashCodeResult = claimStatusDTO.hashCode();
        assertEquals(expectedHashCodeResult, claimStatusDTO1.hashCode());
    }
}

