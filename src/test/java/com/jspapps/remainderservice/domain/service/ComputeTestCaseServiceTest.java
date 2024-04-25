package com.jspapps.remainderservice.domain.service;

import com.jspapps.remainderservice.application.port.in.IComputeTestCaseUseCase;
import com.jspapps.remainderservice.domain.model.TestCasesDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ComputeTestCaseServiceTest {

    @InjectMocks
    private ComputeTestCaseService computeTestCaseServiceUnderTest;

    @Mock
    private IComputeTestCaseUseCase computeTestCaseUseCase;

    @BeforeEach
    void init() {
    }

    @Test
    void givenTestCasesRequest_thenReturnNumberListSuccessfully() {
        TestCasesDTO testCasesDTO = new TestCasesDTO();
        testCasesDTO.setNumberTestCases(2);
        testCasesDTO.setTestCases("7 5 12345, 5 0 4");

        int[] numbersResult = new int[] {12339, 0};

        when(computeTestCaseUseCase.computeTestCases(testCasesDTO)).thenReturn(numbersResult);

        int[] maxNumberResult = computeTestCaseServiceUnderTest.computeTestCases(testCasesDTO);
        assertNotNull(maxNumberResult);
    }
}
