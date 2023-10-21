package com.smartfactory.apiserver.api.contract.controller;


import com.smartfactory.apiserver.api.contract.service.ContractService;
import com.smartfactory.apiserver.common.response.ApiResponseCode;
import com.smartfactory.apiserver.common.response.BaseResponse;
import com.smartfactory.apiserver.common.response.RestApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.smartfactory.apiserver.api.contract.dto.ContractDTO.*;

@RestController
@RequestMapping("/api/v2/contract")
@Slf4j
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;

    @GetMapping(value = "/estimate-contracts")
    public ResponseEntity<?> getEstimateContracts(@Valid GetEstimateContractsRequest request) {
        GetEstimateContractsResponse response = contractService.getEstimateContracts(request);
        RestApiResponse restApiResponse = new RestApiResponse();
        restApiResponse.setResult(new BaseResponse(ApiResponseCode.SUCCESS), response);
        return new ResponseEntity<>(restApiResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/estimate-contract", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> writeEstimateContract(@Valid @RequestBody WriteEstimateContractRequest request) {
        contractService.writeEstimateContract(request);
        RestApiResponse restApiResponse = new RestApiResponse();
        restApiResponse.setResult(new BaseResponse(ApiResponseCode.SUCCESS));
        return new ResponseEntity<>(restApiResponse, HttpStatus.OK);
    }


    @PostMapping(value = "/store-contracts", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> writeStoreContract(@Valid @RequestBody WriteStoreContractRequest request) {
        contractService.writeStoreContract(request);
        RestApiResponse restApiResponse = new RestApiResponse();
        restApiResponse.setResult(new BaseResponse(ApiResponseCode.SUCCESS));
        return new ResponseEntity<>(restApiResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/store-contracts")
    public ResponseEntity<?> getStoreContract(@Valid GetStoreContractsRequest getStoreContractsRequest) {
        GetStoreContractsResponse response = contractService.getStoreContracts(getStoreContractsRequest);
        RestApiResponse restApiResponse = new RestApiResponse();
        restApiResponse.setResult(new BaseResponse(ApiResponseCode.SUCCESS), response);
        return new ResponseEntity<>(restApiResponse, HttpStatus.OK);
    }


}
