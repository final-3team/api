package com.smartfactory.apiserver.domain.database.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static com.smartfactory.apiserver.common.constant.CommonCode.*;

@Table(name = "post")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class PostEntity {
    @Id
    @Column(name = "post_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postSeq;
    @ManyToOne
    @JoinColumn(name = "user_seq", referencedColumnName = "user_seq", nullable = false)
    private UserEntity user;
    @Column(name = "category", length = 45, nullable = false)
    @Enumerated(EnumType.STRING)
    private PostCategory category;
    @Column(name = "title", length = 45, nullable = false)
    private String title;
    @Column(name = "body", nullable = false)
    @Lob
    private String body;
    @Column(name = "create_at", nullable = false)
    @CreationTimestamp
    private Date createAt;
    @Column(name = "update_at")
    @UpdateTimestamp
    private Date updateAt;

    @Column(name = "status", length = 45, nullable = false)
    @Enumerated(EnumType.STRING)
    private PostStatus status;


    @Column(name = "password", length = 45)
    private String password;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CommentEntity> commentEntityList;

    @Builder
    public PostEntity(Long postSeq, UserEntity user, PostCategory category, String title, String body, Date createAt, Date updateAt, PostStatus status, String password) {
        this.postSeq = postSeq;
        this.user = user;
        this.category = category;
        this.title = title;
        this.body = body;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.status = status;
        this.password = password;
    }
}
