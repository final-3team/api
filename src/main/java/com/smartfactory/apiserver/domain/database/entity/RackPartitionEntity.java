package com.smartfactory.apiserver.domain.database.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "rack_partition")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class RackPartitionEntity {
    @Id
    @Column(name = "partition_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partition_seq;
    @ManyToOne
    @JoinColumn(name = "rack_seq", referencedColumnName = "rack_seq", nullable = false)
    private PalletRackEntity palletRack;
    @Column(name = "location", length = 45, nullable = false)
    private String location;
    @OneToOne
    @JoinColumn(name = "work_seq", referencedColumnName = "work_seq")
    private RackingWorkEntity lastRackingWork;

    @Builder
    public RackPartitionEntity(Long partition_seq, PalletRackEntity palletRack, String location, RackingWorkEntity lastRackingWork) {
        this.partition_seq = partition_seq;
        this.palletRack = palletRack;
        this.location = location;
        this.lastRackingWork = lastRackingWork;
    }
}
