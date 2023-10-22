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
    public static class GetEstimateContract{
        @NotNull
        private final Long id;
        @NotNull
        private final StoreType classification;
        @NotNull
        private final WarehouseArea location;
        @NotNull
        private final Integer storingQuantity;
    }

    @Data
    public static class WriteEstimateContractRequest {
        @NotNull
        private final Integer deposit;
        @NotNull
        private  final String warehouseArea;
        @NotNull
        private final StoreType storeType;
        @NotNull
        private final Integer productQuantity;
    }

    @Data
    public static class WriteStoreContractRequest {
        @NotNull
        private final Long storeContractSeq;
        @NotNull
        private final String dateOfStore;
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
        private final StoreType storeType;
        @NotNull
        private final int productQuantity;
    }

    @Data
    public static class GetStoreContractsResponse {
        @NotNull
        List<GetStoreContracts> contracts;
    }

    @Data
    public static class CreateContractTerminationRequest{
        @NotNull
        private final Long contractSeq;
        @NotNull
        private final String releaseDate;
    }

}
