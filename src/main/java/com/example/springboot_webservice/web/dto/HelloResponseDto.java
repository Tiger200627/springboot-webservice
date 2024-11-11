package com.example.springboot_webservice.web.dto;

// lombok 활용하기
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언된 모든 필드의 get 메소드를 생성 //
@RequiredArgsConstructor // 선언된 모들 final 필드가 포함된 생성자를 생성
public class HelloResponseDto {

    private final String name;
    private final int amount;

}

/*

Spring 프로젝트에서 Lombok을 활용하면 반복적인 코드를 줄여 개발을 효율화할 수 있습니다.
Lombok은 Getter, Setter, toString, Equals, HashCode, Builder 등 메서드와 생성자 등을 자동으로 생성해 주기 때문에, 개발자는 주요 로직에 집중할 수 있습니다.

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.Builder;

@Getter  // 모든 필드에 Getter 메서드 생성
@Setter  // 모든 필드에 Setter 메서드 생성
@NoArgsConstructor  // 파라미터가 없는 기본 생성자 생성
@AllArgsConstructor  // 모든 필드를 포함한 생성자 생성
@ToString  // toString 메서드 자동 생성
@EqualsAndHashCode  // equals, hashCode 메서드 자동 생성
@Builder  // 빌더 패턴 자동 생성

* */