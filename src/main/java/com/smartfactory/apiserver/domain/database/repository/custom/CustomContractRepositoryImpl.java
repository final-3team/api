package com.smartfactory.apiserver.domain.database.repository.custom;

import com.querydsl.core.types.Projections;
import com.smartfactory.apiserver.common.constant.CommonCode;
import com.smartfactory.apiserver.domain.database.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.smartfactory.apiserver.api.contract.dto.ContractDTO.*;

@Repository
@Slf4j
public class CustomContractRepositoryImpl extends QuerydslRepositorySupport implements CustomContractRepository {

    public CustomContractRepositoryImpl() { super(StoreContractEntity.class);}
    @Override
    @Transactional(readOnly = true)
    public GetEstimateContractsResponse findEstimateContracts(GetEstimateContractsRequest request, Long userSeq) {
        try{
            QStoreContractEntity storeContractEntity = QStoreContractEntity.storeContractEntity;
            List<GetEstimateContract> data = (List<GetEstimateContract>) from(storeContractEntity)
                    .where(storeContractEntity.customer.userSeq.eq(userSeq)
                            , storeContractEntity.contractStatus.eq(CommonCode.ContractStatus.BEFORE_CONTRACT)
                    )
                    .orderBy(storeContractEntity.writeAt.desc())
                    .transform(groupBy(storeContractEntity.contractSeq).list(
                            Projections.constructor(
                                    GetEstimateContract.class
                                , storeContractEntity.contractSeq
                                , storeContractEntity.storeType
                                , storeContractEntity.storeLocation.warehouseArea
                                , storeContractEntity.productQuantity
                            )
                        )
                    );
            GetEstimateContractsResponse response = new GetEstimateContractsResponse(data);
            return response;
        }catch (Exception e){
            log.error(e.getMessage());
            throw e;
        }


    }

    @Override
    public GetStoreContractsResponse findStoreContractsByUserEntity(GetStoreContractsRequest request, UserEntity userEntity) {
        try{
            QStoreContractEntity storeContractEntity = QStoreContractEntity.storeContractEntity;
            List<GetStoreContracts> data = (List<GetStoreContracts>) from(storeContractEntity)
                    .where(storeContractEntity.customer.userSeq.eq(userEntity.getUserSeq())
                            , storeContractEntity.contractStatus.eq(CommonCode.ContractStatus.IN_CONTRACT)
                    )
                    .orderBy(storeContractEntity.storeDate.desc())
                    .transform(groupBy(storeContractEntity.contractSeq).list(Projections.constructor(GetStoreContracts.class
                            , storeContractEntity.contractSeq
                            , storeContractEntity.storeDate
                            , storeContractEntity.storeLocation.warehouseArea
                            , storeContractEntity.storeType
                            , storeContractEntity.productQuantity
                    )));
            return new GetStoreContractsResponse(data);
        }catch (Exception e){
            log.error(e.getMessage());
            throw e;
        }
    }


}
