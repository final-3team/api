package com.smartfactory.apiserver.domain.database.repository;

import com.smartfactory.apiserver.domain.database.entity.StoreContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreContractRepository extends JpaRepository<StoreContractEntity, Long> {
}
