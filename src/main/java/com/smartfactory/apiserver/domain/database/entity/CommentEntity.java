package com.smartfactory.apiserver.domain.database.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "comment")
@Entity
@Setter
@Getter
@NoArgsConstructor
public class CommentEntity {
    @Id
    @Column(name = "comment_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentSeq;
    @ManyToOne
    @JoinColumn(name = "user_seq", referencedColumnName = "user_seq", nullable = false)
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "post_seq", referencedColumnName = "post_seq", nullable = false)
    private PostEntity post;
    @Column(name = "content")
    @Lob
    private String content;
    @Column(name = "create_at", nullable = false)
    @CreationTimestamp
    private Date createAt;
    @Column(name = "update_at")
    @UpdateTimestamp
    private Date updateAt;

    @Builder
    public CommentEntity(Long commentSeq, UserEntity user, PostEntity post, String content, Date createAt, Date updateAt) {
        this.commentSeq = commentSeq;
        this.user = user;
        this.post = post;
        this.content = content;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}


