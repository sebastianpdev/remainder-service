package com.jspapps.remainderservice.domain.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.Objects;

public class TestCasesDTO {

    @Positive
    private int numberTestCases;

    @Pattern(regexp = "^(\\d+\\s+\\d+\\s+\\d+(,\\s+|$)){1,}$")
    private String testCases;

    public int getNumberTestCases() {
        return numberTestCases;
    }

    public TestCasesDTO setNumberTestCases(int numberTestCases) {
        this.numberTestCases = numberTestCases;
        return this;
    }

    public String getTestCases() {
        return testCases;
    }

    public TestCasesDTO setTestCases(String testCases) {
        this.testCases = testCases;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestCasesDTO that = (TestCasesDTO) o;
        return numberTestCases == that.numberTestCases && Objects.equals(testCases, that.testCases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberTestCases, testCases);
    }
}
