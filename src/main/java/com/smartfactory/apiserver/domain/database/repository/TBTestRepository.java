package com.smartfactory.apiserver.domain.database.repository;

import com.smartfactory.apiserver.domain.database.entity.TBTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface TBTestRepository extends JpaRepository<TBTestEntity, Long> {
    Optional<TBTestEntity> findTbTestEntityBySeqAndName(Long seq, String name);
}
