package com.smartfactory.apiserver.domain.database.entity;

import com.smartfactory.apiserver.common.constant.CommonCode;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static com.smartfactory.apiserver.common.constant.CommonCode.*;

@Table(name = "store_contract")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class StoreContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_seq")
    private Long contractSeq;
    @ManyToOne
    @JoinColumn(name = "customer_seq", referencedColumnName = "user_seq", nullable = false)
    private UserEntity customer;
    @ManyToOne
    @JoinColumn(name = "staff_seq", referencedColumnName = "staff_seq", nullable = false)
    private StaffEntity staff;
    @Column(name = "contract_status", length = 45, nullable = false)
    @Enumerated(EnumType.STRING)
    private ContractStatus contractStatus;
    @Column(name = "store_date")
    @UpdateTimestamp
    private Date storeDate;
    @Column(name = "deposit", length = 10)
    private Integer deposit;
    @Column(name = "write_at")
    @UpdateTimestamp
    private Date writeAt;
    @ManyToOne
    @JoinColumn(name = "location", referencedColumnName = "warehouse_seq", nullable = false)
    private WarehouseEntity storeLocation;
    @Column(name = "store_type", length = 45, nullable = false)
    @Enumerated(EnumType.STRING)
    private StoreType storeType;
    @Column(name = "product_quantity", length = 10, nullable = false)
    private Integer productQuantity;
    @OneToMany(mappedBy = "storeContract", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PalletEntity> palletEntityList;

    @Builder
    public StoreContractEntity(Long contractSeq, UserEntity customer, StaffEntity staff, ContractStatus contractStatus, Date storeDate, Integer deposit, Date writeAt, WarehouseEntity storeLocation, StoreType storeType, Integer productQuantity) {
        this.contractSeq = contractSeq;
        this.customer = customer;
        this.staff = staff;
        this.contractStatus = contractStatus;
        this.storeDate = storeDate;
        this.deposit = deposit;
        this.writeAt = writeAt;
        this.storeLocation = storeLocation;
        this.storeType = storeType;
        this.productQuantity = productQuantity;
    }
}
