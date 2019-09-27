package com.framework.tests;

import com.framework.core.utils.RequestBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@DisplayName("Verify account endpoints return code 200")
@Execution(CONCURRENT)
@Slf4j
@Tag("API")
public class AccountTest {

    @DisplayName("Verify account endpoints return code 200")
    @ParameterizedTest(name = "{0} endpoint returns code 200")
    @CsvFileSource(resources = "/parametrized/endpoints.csv")
    public void verifyEndpointsReturnCode200(String path){
        Assertions.assertEquals(RequestBuilder.get(path).statusCode(), 200);
    }
}
