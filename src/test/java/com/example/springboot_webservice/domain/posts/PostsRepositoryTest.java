package com.example.springboot_webservice.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void getPostsSave(){

        //given
        String title = "test_title";
        String content = "test_content";
        postsRepository.save(Posts.builder() // save() insert/update 쿼리 실행
                .title(title)
                .content(content)
                .author("test@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll(); // findAll() 모든 데이터를 조회

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}

/*
    JUnit 4의 주요 어노테이션 - JUnit 5로 업데이트

    @Before → @BeforeEach
    @After → @AfterEach
    @BeforeClass → @BeforeAll
    @AfterClass → @AfterAll

*/