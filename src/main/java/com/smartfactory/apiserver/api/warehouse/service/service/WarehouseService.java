package com.smartfactory.apiserver.api.warehouse.service.service;

import com.smartfactory.apiserver.api.warehouse.service.dto.WarehouseDTO;

public interface WarehouseService {
    WarehouseDTO.TestResponse Test(WarehouseDTO.TestRequest testrequest);

}
