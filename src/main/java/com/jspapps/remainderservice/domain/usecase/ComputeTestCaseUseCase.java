package com.jspapps.remainderservice.domain.usecase;

import com.jspapps.remainderservice.application.port.in.IComputeTestCaseUseCase;
import com.jspapps.remainderservice.domain.model.TestCasesDTO;
import com.jspapps.remainderservice.infrastructure.util.annotation.UseCase;

import java.util.Arrays;
import java.util.logging.Logger;

@UseCase
public class ComputeTestCaseUseCase implements IComputeTestCaseUseCase {

    private static final Logger LOG = Logger.getLogger(ComputeTestCaseUseCase.class.getName());

    private static final String TEST_CASE_DELIMITER_FLAG = ", ";
    private static final String TEST_CASE_NUMBER_DELIMITER_FLAG = " ";
    private static final int NUMBER_ONE_POSITION = 0;
    private static final int NUMBER_TWO_POSITION = 1;
    private static final int NUMBER_THREE_POSITION = 2;

    @Override
    public int[] computeTestCases(TestCasesDTO testCasesDTO) {
        int[] maxNumberResult = new int[testCasesDTO.getNumberTestCases()];
        int[][] testCasesList = prepareTestCasesToEvaluate(testCasesDTO.getTestCases());

        for (int i = 0; i < testCasesDTO.getNumberTestCases(); i++) {
            int x = testCasesList[i][NUMBER_ONE_POSITION];
            int y = testCasesList[i][NUMBER_TWO_POSITION];
            int n = testCasesList[i][NUMBER_THREE_POSITION];

            int k = (n - y) / x * x + y;
            maxNumberResult[i] = k;
        }

        return maxNumberResult;
    }

    private int[][] prepareTestCasesToEvaluate(String testCases) {
        return Arrays.stream(testCases.split(TEST_CASE_DELIMITER_FLAG))
            .map(testCase -> Arrays.stream(testCase.split(TEST_CASE_NUMBER_DELIMITER_FLAG))
                .mapToInt(Integer::parseInt)
                .toArray())
            .toArray(int[][]::new);
    }
}
