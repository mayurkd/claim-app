package com.mfpe.memberService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import springfox.documentation.spring.web.plugins.Docket;

class MemberServiceApplicationTest {
    @Test
    void testConfigureSwagger2() {
        Docket actualConfigureSwagger2Result = (new MemberServiceApplication()).configureSwagger2();
        assertTrue(actualConfigureSwagger2Result.isEnabled());
        assertEquals("default", actualConfigureSwagger2Result.getGroupName());
    }
}

