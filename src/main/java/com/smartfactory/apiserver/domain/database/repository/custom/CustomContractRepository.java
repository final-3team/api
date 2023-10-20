package com.smartfactory.apiserver.domain.database.repository.custom;

import com.smartfactory.apiserver.api.contract.dto.ContractDTO;
import com.smartfactory.apiserver.domain.database.entity.UserEntity;

import java.util.Optional;

import static com.smartfactory.apiserver.api.contract.dto.ContractDTO.*;

public interface CustomContractRepository {

    GetEstimateContractsResponse findEstimateContracts(GetEstimateContractsRequest request, Long userSeq);

}
