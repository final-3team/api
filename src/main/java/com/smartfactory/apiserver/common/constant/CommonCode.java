package com.smartfactory.apiserver.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class CommonCode {
    public enum UserStatus{
        USE, //사용
        WITHDRAW,   //탈퇴
        DORMANT;    //휴면
    }

    public enum PalletStatus{
        BEFORE_STOCK,   // 입고전
        IN_STOCK,       // 입고중
        STOCK_COMPLETE;  // 입고 완료
    }

    public enum PalletRackStatus{
        AVAILABLE,      //사용 가능
        UNAVAILABLE;    //사용 불가
    }

    public enum PostCategory{
        ANNOUNCEMENT,   //공지 사항
        COMMON;         //일반 게시글
    }

    public enum PostStatus{
        ACTIVE,         //활성
        INACTIVE;       //비활성
    }
    public enum StoreType{
        COLD_STORAGE,   //냉장
        FROZEN_STORAGE, //냉동
        ROOM_STORAGE;   //실온, 상온

    }

    public enum RackingWorkType{
        STORE,      //입고
        RELEASE,    //출고
        MOVE;       //이동
    }

    public enum RackingWorkProgress{
        BEFORE_PROGRESS,    //진행전
        IN_PROGRESS,        //진행중
        AFTER_PROGRESS,     //진행 완료
        DISCORD_PROGRESS;   //진행 취소
    }

    public enum ContractStatus{
        BEFORE_CONTRACT,    //계약 전
        IN_CONTRACT,        //계약 협의 중
        COMPLETE_CONTRACT,  //계약 완료
        FINISH_CONTRACT,    //계약 종료
        EXPIRE_CONTRACT;    //계약 파기

    }

    public enum Department{
        WAITING_FOR_DISPATCHING,    //발령대기
        BUSINESS,       //사업부
        MANAGE;         //관리부

    }

    public enum StaffStatus{
        LEAVE_OF_ABSENCE,   //휴직
        RETIREMENT,         //퇴직, 은퇴
        ON_WORK;            //현직
    }

    public enum WarehouseArea{
        SEOUL_A,
        SEOUL_B,
        BUSAN_A,
        BUSAN_B,


    }

    @Getter
    @AllArgsConstructor
    public enum UserAuthority{
        ROLE_SUPER_ADMIN("슈퍼 관리자"),
        ROLE_STAFF("매니저"),
        ROLE_WORKER("근로자"),
        ROLE_GENERAL("일반사용자");
        private String desc;
    }
}
