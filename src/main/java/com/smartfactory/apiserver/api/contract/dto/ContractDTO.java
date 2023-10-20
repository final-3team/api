package com.smartfactory.apiserver.api.contract.dto;

import com.smartfactory.apiserver.common.constant.CommonCode;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

import static com.smartfactory.apiserver.common.constant.CommonCode.*;

public class ContractDTO {

    @Data
    public static class GetEstimateContractsRequest{

    }

    @Data
    @AllArgsConstructor
    public static class GetEstimateContractsResponse{
        List<GetEstimateContract> contents;
    }

    @Data
    @AllArgsConstructor
    public static class GetEstimateContract{
        @NotNull
        private Long id;
        @NotNull
        private StoreType classification;
        @NotNull
        private WarehouseArea location;
        @NotNull
        private Integer storingQuantity;
    }

    @Data
    public static class WriteEstimateContractRequest{
        @NotNull
        private Integer deposit;
        @NotNull
        private String warehouseArea;
        @NotNull
        private StoreType storeType;
        @NotNull
        private Integer productQuantity;
    }



    @Data
    public static class GetStoreContractsRequest{

    }

    @Data
    public static class GetStoreContractsResponse{

    }

}