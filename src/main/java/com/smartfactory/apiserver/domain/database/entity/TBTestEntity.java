package com.smartfactory.apiserver.domain.database.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_test")
@Getter
@Setter
@NoArgsConstructor
public class TBTestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false)
    private Long seq;
    @Column(name = "name", length = 200)
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at")
    @CreationTimestamp
    private Date createAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at")
    @UpdateTimestamp
    private Date updateAt;

    @Builder
    public TBTestEntity(Long seq, String name, Date createAt, Date updateAt) {
        this.seq = seq;
        this.name = name;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
