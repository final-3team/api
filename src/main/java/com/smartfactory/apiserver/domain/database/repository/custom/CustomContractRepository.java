package com.smartfactory.apiserver.domain.database.repository.custom;

import com.smartfactory.apiserver.domain.database.entity.UserEntity;

import static com.smartfactory.apiserver.api.contract.dto.ContractDTO.*;

public interface CustomContractRepository {

    GetEstimateContractsResponse findEstimateContracts(GetEstimateContractsRequest request, Long userSeq);

    GetStoreContractsResponse findStoreContractsByUserEntity(GetStoreContractsRequest request , UserEntity userEntity);

}
