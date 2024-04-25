package com.jspapps.remainderservice.application.port.in;

import com.jspapps.remainderservice.domain.model.TestCasesDTO;

public interface IComputeTestCaseService {

    int[] computeTestCases(TestCasesDTO testCasesDTO);
}
