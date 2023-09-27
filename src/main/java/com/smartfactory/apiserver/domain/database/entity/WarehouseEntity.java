package com.smartfactory.apiserver.domain.database.entity;

import com.smartfactory.apiserver.common.constant.CommonCode;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static com.smartfactory.apiserver.common.constant.CommonCode.*;

@Table(name = "warehouse")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class WarehouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_seq")
    private Long warehouseSeq;
    @Column(name = "area", length = 45, nullable = false)
    @Enumerated(EnumType.STRING)
    private WarehouseArea warehouseArea;
    @Column(name = "warehouse_name", length = 200, nullable = false, unique = true)
    private String warehouseName;

    @Builder
    public WarehouseEntity(Long warehouseSeq, WarehouseArea warehouseArea, String warehouseName) {
        this.warehouseSeq = warehouseSeq;
        this.warehouseArea = warehouseArea;
        this.warehouseName = warehouseName;
    }
}
