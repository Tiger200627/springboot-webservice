package com.example.springboot_webservice.domain.posts;

// JPA

import com.example.springboot_webservice.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Getter
@NoArgsConstructor
@Entity // 데이터베이스 테이블과 매핑될 클래스
//@Table(name ="posts") 테이블 이름 지정
//Entity 클래스에서는 Setter 메소드를 만들지 않는다. 대신 해당 필드의 값 변경이 필요하면 의도에 맞는 메소드명으로 추가한다.(ex. 주문취소-cancle())
public class Posts extends BaseTimeEntity {

    @Id // 기본키 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동 생성
    private Long id; // PK는 Long 타입 추천

    @Column(length = 500, nullable = false) // 컬럼 매핑, name, nullable, length 지정 가능
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author; // @Column 선언 하지 않으면 기본값으로

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

/*
    참고

    // javax -> jakarta

    jakarta.persistence
    - @OneToOne, @OneToMany, @ManyToOne, @ManyToMany:
    엔터티 간의 연관 관계를 설정하는 어노테이션입니다.
    @OneToOne: 1:1 관계.
    @OneToMany: 1 관계.
    @ManyToOne: N:1 관계.
    @ManyToMany: N 관계.

    - EntityManager 인터페이스:
    엔터티와 관련된 CRUD 작업을 수행하는 주요 API입니다.
    주요 메서드:
    persist(Object entity): 엔터티를 저장합니다.
    find(Class<T> entityClass, Object primaryKey): 기본 키로 엔터티를 조회합니다.
    merge(Object entity): 엔터티 정보를 업데이트합니다.
    remove(Object entity): 엔터티를 삭제합니다.
    createQuery(String qlString): JPQL 쿼리를 생성해 실행합니다.

    - Query 인터페이스:
    JPQL(Java Persistence Query Language) 쿼리를 실행하고, 쿼리의 결과를 가져오는 데 사용됩니다.
    주요 메서드:
    getResultList(): 쿼리 결과 목록을 반환합니다.
    getSingleResult(): 쿼리 결과에서 단일 결과만 가져옵니다.
    setParameter(String name, Object value): 쿼리 매개변수를 설정합니다.

    - Transaction 인터페이스:
    트랜잭션을 제어하는 데 사용되며, 데이터베이스 작업을 논리적으로 묶어서 처리할 수 있게 해줍니다.
    주요 메서드:
    begin(): 트랜잭션을 시작합니다.
    commit(): 트랜잭션을 커밋합니다.
    rollback(): 트랜잭션을 롤백합니다.
*/