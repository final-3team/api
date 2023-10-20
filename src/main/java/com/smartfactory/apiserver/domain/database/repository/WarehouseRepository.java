package com.smartfactory.apiserver.domain.database.repository;

import com.smartfactory.apiserver.common.constant.CommonCode;
import com.smartfactory.apiserver.common.constant.CommonCode.WarehouseArea;
import com.smartfactory.apiserver.domain.database.entity.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Long> {

    Optional<WarehouseEntity> findWarehouseEntityByWarehouseArea(WarehouseArea warehouseArea);

}
