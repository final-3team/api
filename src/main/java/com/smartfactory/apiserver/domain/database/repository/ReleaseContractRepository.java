package com.smartfactory.apiserver.domain.database.repository;

import com.smartfactory.apiserver.domain.database.entity.ReleaseContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseContractRepository extends JpaRepository<ReleaseContractEntity, Long> {
}
