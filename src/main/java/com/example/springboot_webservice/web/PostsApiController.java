package com.example.springboot_webservice.web;

import com.example.springboot_webservice.service.posts.PostsService;
import com.example.springboot_webservice.web.dto.PostsResponseDto;
import com.example.springboot_webservice.web.dto.PostsSaveRequestDto;
import com.example.springboot_webservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts") // 등록
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}") // 수정
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

}
/*
    주요 Mapping 어노테이션
    @RequestMapping(value = "/path", method = RequestMethod.GET): 모든 HTTP 메서드를 지원하는 범용 매핑 어노테이션으로, URL 경로와 요청을 매핑.
    @GetMapping("/path"): HTTP GET 요청을 매핑, 주로 데이터를 조회할 때 사용.
    @PostMapping("/path"): HTTP POST 요청을 매핑, 새로운 리소스를 생성할 때 사용.
    @PutMapping("/path"): HTTP PUT 요청을 매핑, 기존 리소스를 업데이트할 때 사용.
    @DeleteMapping("/path/{id}"): HTTP DELETE 요청을 매핑, 리소스를 삭제할 때 사용.
    @PatchMapping("/path/{id}"): HTTP PATCH 요청을 매핑, 리소스의 일부를 수정할 때 사용.
*/
