package com.smartfactory.apiserver.api.contract.service;


import static com.smartfactory.apiserver.api.contract.dto.ContractDTO.*;

public interface ContractService {

    GetEstimateContractsResponse getEstimateContracts(GetEstimateContractsRequest request);

    void writeEstimateContract(WriteEstimateContractRequest request);

    void writeStoreContract(WriteStoreContractRequest request);

    GetStoreContractsResponse getStoreContracts(GetStoreContractsRequest getStoreContractsRequest);
}
