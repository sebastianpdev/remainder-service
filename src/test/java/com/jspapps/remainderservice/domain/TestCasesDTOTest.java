package com.jspapps.remainderservice.domain;

import com.jspapps.remainderservice.domain.model.TestCasesDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class TestCasesDTOTest {

    private static Validator validator;

    @BeforeAll
    public static void initValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testNumberTestCasesPattern() {
        TestCasesDTO testCasesDTO = new TestCasesDTO();
        testCasesDTO.setNumberTestCases(2);

        assertTrue(validator.validate(testCasesDTO).isEmpty());
    }

    @Test
    void testInvalidNumberTestCasesPattern() {
        TestCasesDTO testCasesDTO = new TestCasesDTO();
        testCasesDTO.setNumberTestCases(-2);

        assertFalse(validator.validate(testCasesDTO).isEmpty());
    }

    @Test
    void testInvalidTestCasesPattern() {
        TestCasesDTO testCasesDTO = new TestCasesDTO();
        testCasesDTO.setTestCases("7 5 12345,5 0 4");

        assertFalse(validator.validate(testCasesDTO).isEmpty());
    }
}
