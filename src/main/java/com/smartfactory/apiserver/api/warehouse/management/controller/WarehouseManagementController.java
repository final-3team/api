package com.smartfactory.apiserver.api.warehouse.management.controller;


import com.smartfactory.apiserver.api.warehouse.management.dto.WarehouseManagementDTO;
import com.smartfactory.apiserver.api.warehouse.management.service.WarehouseManagementService;
import com.smartfactory.apiserver.common.response.ApiResponseCode;
import com.smartfactory.apiserver.common.response.BaseResponse;
import com.smartfactory.apiserver.common.response.RestApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v2/management/warehouse")
@Slf4j
@RequiredArgsConstructor
public class WarehouseManagementController {
    private final WarehouseManagementService warehouseService;


    @GetMapping(value = "/test/inventoryStatus")
    @ResponseBody
    public ResponseEntity<?> Test(@Valid WarehouseManagementDTO.TestRequest testRequest) {
        WarehouseManagementDTO.TestResponse response = warehouseService.Test(testRequest);
        RestApiResponse restApiResponse = new RestApiResponse();
        restApiResponse.setResult(new BaseResponse(ApiResponseCode.SUCCESS), response);
        return new ResponseEntity<>(restApiResponse, HttpStatus.OK);
    }
}
