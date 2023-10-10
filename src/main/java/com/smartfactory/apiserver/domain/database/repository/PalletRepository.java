package com.smartfactory.apiserver.domain.database.repository;


import com.smartfactory.apiserver.domain.database.entity.PalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalletRepository extends JpaRepository<PalletEntity, Long> {
}
