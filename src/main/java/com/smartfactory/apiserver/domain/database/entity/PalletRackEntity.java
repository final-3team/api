package com.smartfactory.apiserver.domain.database.entity;


import com.smartfactory.apiserver.common.constant.CommonCode;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static com.smartfactory.apiserver.common.constant.CommonCode.*;

@Table(name = "pallet_rack")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class PalletRackEntity {
    @Id
    @Column(name = "rack_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rackSeq;
    @ManyToOne
    @JoinColumn(name = "warehouse_partition", referencedColumnName = "partition_seq", nullable = false)
    private WarehousePartitionEntity warehousePartition;
    @Column(name = "status", length = 45, nullable = false)
    @Enumerated(EnumType.STRING)
    private PalletRackStatus status;
    @Column(name = "location", length = 45, nullable = false)
    private String location;

    @Builder
    public PalletRackEntity(Long rackSeq, WarehousePartitionEntity warehousePartition, PalletRackStatus status, String location) {
        this.rackSeq = rackSeq;
        this.warehousePartition = warehousePartition;
        this.status = status;
        this.location = location;
    }
}
