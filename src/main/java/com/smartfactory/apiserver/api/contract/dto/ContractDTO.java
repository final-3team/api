package com.smartfactory.apiserver.api.contract.dto;

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
    public static class GetEstimateContractsResponse{
        private final List<GetEstimateContract> contents;
    }

    @Data
    @AllArgsConstructor
    public static class GetEstimateContract{
        @NotNull
        private Long contractSeq;
        @NotNull
        private StoreType storeType;
        @NotNull
        private WarehouseArea warehouseArea;
        @NotNull
        private Integer productQuantity;
        @NotNull
        private String productName;
        @NotNull
        private Date StoreDate;
        @NotNull
        private Enum contractStatus;
    }

    @Data
    public static class WriteEstimateContractRequest {
        @NotNull
        private Integer deposit;
        @NotNull
        private  String warehouseArea;
        @NotNull
        private StoreType storeType;
        @NotNull
        private Integer productQuantity;
        @NotNull
        private String productName;
    }

    @Data
    public static class WriteStoreContractRequest {
        @NotNull
        private Long storeContractSeq;
        @NotNull
        private String dateOfStore;
    }



    @Data
    public static class GetStoreContractsRequest{

    }
    @Data
    public static class GetStoreContracts{
        @NotNull
        private final Long storeContractSeq;
        @NotNull
        private final Date StoreDate;
        @NotNull
        private final WarehouseArea warehouseArea;
        @NotNull
        private final String storeType;
        @NotNull
        private final int productQuantity;
    }

    @Data
    public static class GetStoreContractsResponse {
        @NotNull
        private final List<GetStoreContracts> contracts;
    }

    @Data
    public static class CreateContractTerminationRequest{
        @NotNull
        private final Long contractSeq;
        @NotNull
        private final String releaseDate;
    }

}
