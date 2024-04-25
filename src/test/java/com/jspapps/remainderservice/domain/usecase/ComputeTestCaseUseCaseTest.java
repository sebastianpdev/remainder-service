package com.jspapps.remainderservice.domain.usecase;

import com.jspapps.remainderservice.domain.model.TestCasesDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ComputeTestCaseUseCaseTest {

    @InjectMocks
    private ComputeTestCaseUseCase computeTestCaseUseCase;

    private TestCasesDTO testCasesDTO;

    @BeforeEach
    void init() {
        testCasesDTO = new TestCasesDTO();
        testCasesDTO.setNumberTestCases(2);
        testCasesDTO.setTestCases("7 5 12345, 5 0 4");
    }

    @Test
    void givenTestCasesRequest_whenComputeTestCaseUseCaseIsCalled_thenReturnNumberListSuccessfully() {
        int[] numbersResult = new int[] {12339, 0};

        int[] maxNumberResult = computeTestCaseUseCase.computeTestCases(testCasesDTO);
        assertEquals(maxNumberResult[0], numbersResult[0]);
    }
}
