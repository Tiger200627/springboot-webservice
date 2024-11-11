package com.example.springboot_webservice.domain.posts;

// JPA

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
//@Repository
public interface PostsRepository extends JpaRepository<Posts, Long>{
}
