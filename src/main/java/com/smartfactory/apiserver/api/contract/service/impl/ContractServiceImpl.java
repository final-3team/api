package com.smartfactory.apiserver.api.contract.service.impl;

import com.smartfactory.apiserver.api.contract.service.ContractService;
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

import java.sql.Date;
import java.time.Instant;
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
        try{
            UserEntity userEntity = findUserEntityByToken();
            return customContractRepository.findStoreContractsByUserEntity(getStoreContractsRequest, userEntity);
        }catch (BusinessException e){
            log.error(e.getMessage());
            throw new BusinessException(e.getResponseCode(), e.getStatus());
        }catch(Exception e){
            log.error(e.getMessage());
            throw new BusinessException(ApiResponseCode.UNKNWON, HttpStatus.BAD_REQUEST);
        }
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

    @Override
    public void writeStoreContract(WriteStoreContractRequest request) {
        try {
            StoreContractEntity storeContractEntity = storeContractRepository.findById(request.getStoreContractSeq()).orElseThrow(() -> new BusinessException(ApiResponseCode.FAILED_TO_FIND_STORE_CONTRACT, HttpStatus.BAD_REQUEST));
            storeContractEntity.setContractStatus(ContractStatus.IN_CONTRACT);
            storeContractEntity.setStoreDate(Date.from(Instant.parse(request.getDateOfStore())));
            storeContractEntity = storeContractRepository.save(storeContractEntity);
        }catch (BusinessException e){
            log.error(e.getMessage());
            throw new BusinessException(e.getResponseCode(), e.getStatus());
        }catch (Exception e) {
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

    //token으로 userentity 가져오는 메서드
    @Transactional(readOnly = true)
    public UserEntity validByTokenIdAndPostOwner() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity userEntity = userRepository.findUserEntityByUserId(auth.getName()).orElseThrow(() -> new BusinessException(ApiResponseCode.FAILED_SIGN_IN_USER, HttpStatus.BAD_REQUEST));
        return userEntity;
    }

}
