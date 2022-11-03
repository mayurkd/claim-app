package com.mfpe.memberService.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.mfpe.memberService.model.ErrorMessage;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;

class ControllerExceptionHandlerTest {
    @Test
    void testInvalidPolicyId() {
        ControllerExceptionHandler controllerExceptionHandler = new ControllerExceptionHandler();
        InvalidClaimIdException e = new InvalidClaimIdException("An error occurred");
        ResponseEntity<ErrorMessage> actualInvalidPolicyIdResult = controllerExceptionHandler.invalidPolicyId(e,
                new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualInvalidPolicyIdResult.getHeaders().isEmpty());
        assertTrue(actualInvalidPolicyIdResult.hasBody());
        assertEquals(HttpStatus.FORBIDDEN, actualInvalidPolicyIdResult.getStatusCode());
        ErrorMessage body = actualInvalidPolicyIdResult.getBody();
        assertEquals(404, body.getStatusCode());
        assertEquals("uri=", body.getDescription());
        assertEquals("An error occurred", body.getMessage());
    }

    @Test
    void testInvalidMemberId() {
        ControllerExceptionHandler controllerExceptionHandler = new ControllerExceptionHandler();
        InvalidMemberIdException e = new InvalidMemberIdException("An error occurred");
        ResponseEntity<ErrorMessage> actualInvalidMemberIdResult = controllerExceptionHandler.invalidMemberId(e,
                new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualInvalidMemberIdResult.getHeaders().isEmpty());
        assertTrue(actualInvalidMemberIdResult.hasBody());
        assertEquals(HttpStatus.FORBIDDEN, actualInvalidMemberIdResult.getStatusCode());
        ErrorMessage body = actualInvalidMemberIdResult.getBody();
        assertEquals(404, body.getStatusCode());
        assertEquals("uri=", body.getDescription());
        assertEquals("An error occurred", body.getMessage());
    }

    @Test
    void testFeignExceptionHandling() {
        ControllerExceptionHandler controllerExceptionHandler = new ControllerExceptionHandler();
        FeignException e = mock(FeignException.class);
        ResponseEntity<ErrorMessage> actualFeignExceptionHandlingResult = controllerExceptionHandler
                .feignExceptionHandling(e, new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualFeignExceptionHandlingResult.getHeaders().isEmpty());
        assertTrue(actualFeignExceptionHandlingResult.hasBody());
        assertEquals(HttpStatus.FORBIDDEN, actualFeignExceptionHandlingResult.getStatusCode());
        ErrorMessage body = actualFeignExceptionHandlingResult.getBody();
        assertEquals(404, body.getStatusCode());
        assertEquals("uri=", body.getDescription());
        assertEquals("Token is either expired or invalid...", body.getMessage());
    }
}

