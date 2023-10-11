package com.smartfactory.apiserver.api.warehouse.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class WarehouseDTO {

    @Data
    public static class TestRequest{
        @NotEmpty
        private String warehouse;
       /* warehouse*/
    }

    @Data
    public static class TestResponse{
        @NotEmpty
        private List<TestData> dataList;
        /* warehouse*/
    }

    @Data
    @AllArgsConstructor
    public static class TestData{
        private long id;
        private int number;
        private String company;
        private String projectName;
        private int storing_quantity;
        private String releaseday;
        private String period;
        private String orderday;
        private String classification;
        private String storing;
        private String status;
        private String location;
        private String fee;
        private String pallet_quantity;
        private String pallet_size;
        private String contract;
        private String release_request_day;
        private int release_request_quantity;
        private String contract_day;
        private String phone;
        private String address;

    }

}
