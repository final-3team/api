package com.smartfactory.apiserver.domain.database.entity;

import com.smartfactory.apiserver.common.constant.CommonCode;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static com.smartfactory.apiserver.common.constant.CommonCode.*;

@Table(name = "warehouse_partition")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class WarehousePartitionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partition_seq")
    private Long partitionSeq;
    @ManyToOne
    @JoinColumn(name = "warehouser_seq", referencedColumnName = "warehouse_seq", nullable = false)
    private WarehouseEntity warehouse;
    @Column(name = "partition_name", length = 45, nullable = false)
    private String partitionName;
    @Column(name = "type", length = 45, nullable = false)
    @Enumerated(EnumType.STRING)
    private StoreType warehouseType;

    @Builder
    public WarehousePartitionEntity(Long partitionSeq, WarehouseEntity warehouse, String partitionName, StoreType warehouseType) {
        this.partitionSeq = partitionSeq;
        this.warehouse = warehouse;
        this.partitionName = partitionName;
        this.warehouseType = warehouseType;
    }
}
