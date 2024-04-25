package com.jspapps.remainderservice.domain.service;

import com.jspapps.remainderservice.application.port.in.IComputeTestCaseService;
import com.jspapps.remainderservice.application.port.in.IComputeTestCaseUseCase;
import com.jspapps.remainderservice.domain.model.TestCasesDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ComputeTestCaseService implements IComputeTestCaseService {

    private final IComputeTestCaseUseCase computeTestCaseUseCase;

    @Override
    public int[] computeTestCases(TestCasesDTO testCasesDTO) {
        return computeTestCaseUseCase.computeTestCases(testCasesDTO);
    }
}
