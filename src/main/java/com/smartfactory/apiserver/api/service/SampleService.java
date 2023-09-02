package com.smartfactory.apiserver.api.service;

import com.smartfactory.apiserver.api.dto.SampleDTO.GetTBDataResponse;
import org.eclipse.jdt.core.compiler.InvalidInputException;

public interface SampleService {
    String getTestString();
    GetTBDataResponse getTestDataBySeq(Long seq) throws Exception;
}
