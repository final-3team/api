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

@Table(name = "racking_work")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class RackingWorkEntity {
    @Id
    @Column(name = "work_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workSeq;
    @ManyToOne
    @JoinColumn(name = "pallet_seq", referencedColumnName = "pallet_seq", nullable = false)
    private PalletEntity pallet;
    @Column(name = "work_type", nullable = false, length = 45)
    @Enumerated(EnumType.STRING)
    private RackingWorkType workType;
    @Column(name = "manage_at", nullable = false)
    @CreationTimestamp
    private Date manageAt;
    @ManyToOne
    @JoinColumn(name = "manager_seq", referencedColumnName = "staff_seq", nullable = false)
    private StaffEntity manager;
    @Column(name = "progress", length = 45, nullable = false)
    @Enumerated(EnumType.STRING)
    private RackingWorkProgress progress;
    @ManyToOne
    @JoinColumn(name = "partition_seq", referencedColumnName = "partition_seq")
    private RackPartitionEntity partitionOfDestination;
    @ManyToOne
    @JoinColumn(name = "worker_seq", referencedColumnName = "staff_seq")
    private StaffEntity worker;

    @Builder
    public RackingWorkEntity(Long workSeq, PalletEntity pallet, RackingWorkType workType, Date manageAt, StaffEntity manager, RackingWorkProgress progress, RackPartitionEntity partitionOfDestination, StaffEntity worker) {
        this.workSeq = workSeq;
        this.pallet = pallet;
        this.workType = workType;
        this.manageAt = manageAt;
        this.manager = manager;
        this.progress = progress;
        this.partitionOfDestination = partitionOfDestination;
        this.worker = worker;
    }
}
