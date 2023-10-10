package com.smartfactory.apiserver.domain.database.entity;


import com.smartfactory.apiserver.common.constant.CommonCode;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static com.smartfactory.apiserver.common.constant.CommonCode.*;

@Entity
@Table(name = "pallet")
@Setter
@Getter
@NoArgsConstructor
public class PalletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pallet_seq")
    private Long palletSeq;
    @Column(name = "product", length = 45, nullable = false)
    private String product;
    @Column(name = "store_type", length = 45, nullable = false)
    @Enumerated(EnumType.STRING)
    private StoreType storeType;
    @Column(name = "status", length = 45, nullable = false)
    @Enumerated(EnumType.STRING)
    private PalletStatus status;
    @ManyToOne
    @JoinColumn(name = "storecontract_seq", referencedColumnName = "contract_seq")
    private StoreContractEntity storeContract;
    @ManyToOne
    @JoinColumn(name = "partition_seq", referencedColumnName = "partition_seq")
    private RackPartitionEntity partition;

    @Builder
    public PalletEntity(Long palletSeq, String product, StoreType storeType, PalletStatus status, StoreContractEntity storeContract, RackPartitionEntity partition) {
        this.palletSeq = palletSeq;
        this.product = product;
        this.storeType = storeType;
        this.status = status;
        this.storeContract = storeContract;
        this.partition = partition;
    }
}
