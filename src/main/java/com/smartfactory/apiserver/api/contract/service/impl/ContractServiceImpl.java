package com.smartfactory.apiserver.api.contract.service.impl;

import com.smartfactory.apiserver.api.contract.dto.ContractDTO;
import com.smartfactory.apiserver.api.contract.service.ContractService;
import com.smartfactory.apiserver.common.constant.CommonCode;
import com.smartfactory.apiserver.common.exception.BusinessException;
import com.smartfactory.apiserver.common.response.ApiResponseCode;
import com.smartfactory.apiserver.domain.database.entity.StoreContractEntity;
import com.smartfactory.apiserver.domain.database.entity.UserEntity;
import com.smartfactory.apiserver.domain.database.entity.WarehouseEntity;
import com.smartfactory.apiserver.domain.database.repository.StoreContractRepository;
import com.smartfactory.apiserver.domain.database.repository.UserRepository;
import com.smartfactory.apiserver.domain.database.repository.WarehouseRepository;
import com.smartfactory.apiserver.domain.database.repository.custom.CustomContractRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

import static com.smartfactory.apiserver.api.contract.dto.ContractDTO.*;
import static com.smartfactory.apiserver.common.constant.CommonCode.*;


@Service
@RequiredArgsConstructor
@Slf4j
public class ContractServiceImpl implements ContractService {

    private final CustomContractRepository customContractRepository;
    private final StoreContractRepository storeContractRepository;
    private final UserRepository userRepository;
    private final WarehouseRepository warehouseRepository;

    @Override
    public GetStoreContractsResponse getStoreContracts(GetStoreContractsRequest getStoreContractsRequest) {

        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public GetEstimateContractsResponse getEstimateContracts(GetEstimateContractsRequest request) {
        try{
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            return customContractRepository.findEstimateContracts(request, userRepository.findUserEntityByUserId(auth.getName()).get().getUserSeq());
        }catch(Exception e){
            log.error(e.getMessage());
            throw new BusinessException(ApiResponseCode.FAILED_SIGN_UP_USER, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void writeEstimateContract(WriteEstimateContractRequest request) {
        try{
            StoreContractEntity storeContractEntity = StoreContractEntity.builder()
                    .customer(findUserEntityByToken())
                    .staff(null)
                    .contractStatus(ContractStatus.BEFORE_CONTRACT)
                    .storeDate(null)
                    .deposit(null)
                    .writeAt(null)
                    .storeLocation(findWarehouseLocationByWarehouseArea(WarehouseArea.valueOf(request.getWarehouseArea())))
                    .storeType(request.getStoreType())
                    .productQuantity(request.getProductQuantity())
                    .build();
            storeContractEntity = storeContractRepository.save(storeContractEntity);

        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(ApiResponseCode.FAILED_SIGN_UP_USER, HttpStatus.BAD_REQUEST);
        }
    }

    private UserEntity findUserEntityByToken(){
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            return userRepository.findUserEntityByUserId(auth.getName()).get();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(ApiResponseCode.FAILED_SIGN_UP_USER, HttpStatus.BAD_REQUEST);
        }

    }

    private WarehouseEntity findWarehouseLocationByWarehouseArea(WarehouseArea warehouseArea){
        try {
            return warehouseRepository.findWarehouseEntityByWarehouseArea(warehouseArea).get();
        }catch (NoSuchElementException e){
            log.error(e.getMessage());
            throw new BusinessException(ApiResponseCode.FAILED_TO_FIND_WAREHOUSE_AREA, HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(ApiResponseCode.FAILED_SIGN_UP_USER, HttpStatus.BAD_REQUEST);
        }
    }
}
