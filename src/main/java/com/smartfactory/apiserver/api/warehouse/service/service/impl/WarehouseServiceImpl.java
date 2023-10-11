package com.smartfactory.apiserver.api.warehouse.service.service.impl;

import com.smartfactory.apiserver.api.warehouse.service.dto.WarehouseDTO;
import com.smartfactory.apiserver.api.warehouse.service.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WarehouseServiceImpl implements WarehouseService {
    @Override
    public WarehouseDTO.TestResponse Test(WarehouseDTO.TestRequest testrequest) {
        List<WarehouseDTO.TestData> dataList = new ArrayList<>();
        new WarehouseDTO.TestData(1L, 5, "삼성", "로보트", 10,
                "2023.10.20", "10일", "2023.10.17", "일반", "2023.10.10", "보관중",
                "인천-1동-1층", "200,000원", "3", "180", "보기", "2023.10.17",
                10, "2023.10.10", "010-1234-5678", "인천광역시 남동구 구월동 123-4");

        dataList.add(new WarehouseDTO.TestData(1L, 5, "삼성", "로보트", 10,
                "2023.10.20", "10일", "2023.10.17", "일반", "2023.10.10", "보관중",
                "인천-1동-1층", "200,000원", "3", "180", "보기", "2023.10.17",
                10, "2023.10.10", "010-1234-5678", "인천광역시 남동구 구월동 123-4")
        );

        dataList.add(new WarehouseDTO.TestData(2L, 10, "LG", "로보트", 10,
                "2023.10.20", "10일", "2023.10.17", "일반", "2023.10.10", "보관중",
                "인천-1동-1층", "200,000원", "3", "180", "보기", "2023.10.17",
                10, "2023.10.10", "010-1234-5678", "인천광역시 남동구 구월동 123-4")
        );

        dataList.add(new WarehouseDTO.TestData(3L, 15, "DKDK", "로보트", 10,
                "2023.10.20", "10일", "2023.10.17", "일반", "2023.10.10", "보관중",
                "인천-1동-1층", "200,000원", "3", "180", "보기", "2023.10.17",
                10, "2023.10.10", "010-1234-5678", "인천광역시 남동구 구월동 123-4")
        );


        WarehouseDTO.TestResponse response = new WarehouseDTO.TestResponse();
        response.setDataList(dataList);
        return response;
    }
}
