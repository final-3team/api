package com.smartfactory.apiserver.domain.database.repository;

import com.smartfactory.apiserver.domain.database.entity.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Long> {
}
