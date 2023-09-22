package com.smartfactory.apiserver.domain.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "stockmore_user")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    @Column(name = "user_seq")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userSeq;
    @Column(name = "user_id", unique = true, length = 128)
    private String userId;
    @Column(name = "password", length = 200)
    private String password;
    @Column(name = "user_name", length = 50)
    private String userName;
    @Column(name = "phone_number", length = 30)
    private String phoneNumber;
    @Column(name = "email", length = 128)
    private String email;
    @Column(name = "birth", length = 18)
    private String birth;
    @Column(name = "nickname", length = 50)
    private String nickname;
    @Column(name = "profile_image_path", length = 256)
    private String profileImagePath;
    @Column(name = "sns_id", length = 128)
    private String snsId;
    @Column(name = "fcm_token", length = 256)
    private String fcmToken;
    @Column(name = "access_token", length = 256)
    private String accessToken;
    @Column(name = "access_token_expire_at")
    private Long accessTokenExpireAt;
    @Column(name = "refresh_token", length = 256)
    private String refreshToken;
    @Column(name = "refresh_token_expire_at")
    private Long refreshTokenExpireAt;
    @Column(name = "last_login")
    private Date lastLogin;



    @Column(name = "create_at", nullable = false)
    @CreationTimestamp
    private Date createAt;
    @Column(name = "update_at", nullable = false)
    @UpdateTimestamp
    private Date updateAt;

}