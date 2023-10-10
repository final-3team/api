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

@Table(name = "staff")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class StaffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_seq")
    private Long staff_seq;
    @OneToOne
    @JoinColumn(name = "user_seq", referencedColumnName = "user_seq", unique = true, nullable = false)
    private UserEntity user;
    @Column(name = "salary", length = 10, nullable = false)
    private int salaly;
    @Column(name = "department", length = 45, nullable = false)
    @Enumerated(EnumType.STRING)
    private Department department;
    @Column(name = "staff_status", length = 45, nullable = false)
    @Enumerated(EnumType.STRING)
    private StaffStatus status;
    @Column(name = "create_at", nullable = false)
    @CreationTimestamp
    private Date createAt;

    @Builder
    public StaffEntity(Long staff_seq, UserEntity user, int salaly, Department department, StaffStatus status, Date createAt) {
        this.staff_seq = staff_seq;
        this.user = user;
        this.salaly = salaly;
        this.department = department;
        this.status = status;
        this.createAt = createAt;
    }
}
