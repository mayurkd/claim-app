package com.mfpe.memberService.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mfpe.memberService.client.AuthClient;
import com.mfpe.memberService.dto.ClaimStatusDTO;
import com.mfpe.memberService.dto.ValidatingDTO;
import com.mfpe.memberService.model.Bills;
import com.mfpe.memberService.model.ClaimDetails;
import com.mfpe.memberService.service.ClaimStatusAndDetails;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {MemberController.class})
@ExtendWith(SpringExtension.class)
class MemberControllerTest {
    @MockBean
    private AuthClient authClient;

    @MockBean
    private ClaimStatusAndDetails claimStatusAndDetails;

    @Autowired
    private MemberController memberController;

    @Test
    void testGetBills() throws Exception {
        Date date = mock(Date.class);
        when(date.getTime()).thenReturn(10L);
        Date date1 = mock(Date.class);
        when(date1.getTime()).thenReturn(10L);

        Bills bills = new Bills();
        bills.setPolicyId("42");
        bills.setDueDate(date);
        bills.setDueAmount(1);
        bills.setMemberId("42");
        bills.setLateCharge(1);
        bills.setLastPaidDate(date1);
        when(this.claimStatusAndDetails.fetchBills((String) any())).thenReturn(bills);
        when(this.authClient.getsValidity((String) any())).thenReturn(new ValidatingDTO(true));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/memberModule/viewBills/{memberId}", "42")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"memberId\":\"42\",\"policyId\":\"42\",\"lastPaidDate\":10,\"dueAmount\":1,\"lateCharge\":1,\"dueDate\":10}"));
    }

    @Test
    void testReturnClaimStatus() throws Exception {
        when(this.claimStatusAndDetails.fetchClaimStatus((String) any(), (String) any()))
                .thenReturn(new ClaimStatusDTO("42", "Claim Status", "Claim Description"));
        when(this.authClient.getsValidity((String) any())).thenReturn(new ValidatingDTO(true));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/memberModule/getClaimStatus/{claimId}", "42")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"claimId\":\"42\",\"claimStatus\":\"Claim Status\",\"claimDescription\":\"Claim Description\"}"));
    }

    @Test
    void testReturnClaimStatusOnUpdate() throws Exception {
        when(this.claimStatusAndDetails.fetchClaimDetails((ClaimDetails) any(), (String) any()))
                .thenReturn(new ClaimStatusDTO("42", "Claim Status", "Claim Description"));
        when(this.authClient.getsValidity((String) any())).thenReturn(new ValidatingDTO(true));

        ClaimDetails claimDetails = new ClaimDetails();
        claimDetails.setPolicyId("42");
        claimDetails.setRemarks("Remarks");
        claimDetails.setHospitalId("42");
        claimDetails.setStatus("Status");
        claimDetails.setClaimAmount(10.0);
        claimDetails.setClaimId("42");
        claimDetails.setBenefitId("42");
        claimDetails.setDescription("The characteristics of someone or something");
        claimDetails.setMemberId("42");
        String content = (new ObjectMapper()).writeValueAsString(claimDetails);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/memberModule/submitClaim")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"claimId\":\"42\",\"claimStatus\":\"Claim Status\",\"claimDescription\":\"Claim Description\"}"));
    }
}

