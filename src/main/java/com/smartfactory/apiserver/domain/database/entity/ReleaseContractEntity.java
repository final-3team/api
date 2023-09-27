package com.smartfactory.apiserver.domain.database.entity;

import com.smartfactory.apiserver.common.constant.CommonCode;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.util.Date;

import static com.smartfactory.apiserver.common.constant.CommonCode.*;

@Table(name = "release_contract")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ReleaseContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_seq")
    private Long contract_seq;
    @ManyToOne
    @JoinColumn(name = "customer_seq", referencedColumnName = "user_seq", nullable = false)
    private UserEntity customer;
    @ManyToOne
    @JoinColumn(name = "staff_seq", referencedColumnName = "staff_seq", nullable = false)
    private StaffEntity staff;
    @Column(name = "contract_status", length = 45, nullable = false)
    @Enumerated(EnumType.STRING)
    private ContractStatus ContractStatus;
    @Column(name = "pallet_count", length = 10, nullable = false)
    private int countOfPallet;
    @Column(name = "write_at", nullable = false)
    @CreationTimestamp
    private Date writeAT;

    @Builder
    public ReleaseContractEntity(Long contract_seq, UserEntity customer, StaffEntity staff, CommonCode.ContractStatus contractStatus, int countOfPallet, Date writeAT) {
        this.contract_seq = contract_seq;
        this.customer = customer;
        this.staff = staff;
        ContractStatus = contractStatus;
        this.countOfPallet = countOfPallet;
        this.writeAT = writeAT;
    }
}
