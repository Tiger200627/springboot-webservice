package com.example.springboot_webservice.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 상속할 경우 필드들을 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class) // Auditing 기능 포함
public class BaseTimeEntity {

    @CreatedDate // Entity 저장될 때 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회된 Entity 값이 변경할 때 시간 자동 저장
    private LocalDateTime modifiedDate;

}
