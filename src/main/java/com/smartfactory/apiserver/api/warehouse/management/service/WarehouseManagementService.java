package com.smartfactory.apiserver.api.warehouse.management.service;

import com.smartfactory.apiserver.api.warehouse.management.dto.WarehouseManagementDTO;

public interface WarehouseManagementService {
    WarehouseManagementDTO.TestResponse Test(WarehouseManagementDTO.TestRequest testrequest);

}
