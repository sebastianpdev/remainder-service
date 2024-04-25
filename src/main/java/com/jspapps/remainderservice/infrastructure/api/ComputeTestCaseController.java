package com.jspapps.remainderservice.infrastructure.api;

import com.jspapps.remainderservice.domain.model.TestCasesDTO;
import com.jspapps.remainderservice.domain.service.ComputeTestCaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/testcases")
public class ComputeTestCaseController {

    private final ComputeTestCaseService computeTestCaseService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public int[] computeTestCasesForm(@RequestBody TestCasesDTO testCasesDTO) {
        return computeTestCaseService.computeTestCases(testCasesDTO);
    }

}
