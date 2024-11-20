/*
 * 기존에 사용했던 코드를 재사용하려 했으나 WebSecurityConfigurerAdapter는
 * Spring Security 5.7부터 Deprecated(사용 중단) 상태이며, Spring Security 6.x에서는 완전히 제거되었습니다
 * 따라서 새롭게 권장되는 방식인 filterchain을 사용하여 작성해보았다.
 * */
package com.example.springboot_webservice.config.auth;

import com.example.springboot_webservice.domain.user.Role;
import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions
                                .sameOrigin()
                        )
                ) // h2-console 화면을 사용
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll() // 권한 허용
                        .requestMatchers("/api/v1/**").hasRole(Role.USER.name())
                        .anyRequest().authenticated() // 다른 접근은 로그인 시 가능
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                )
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(customOAuth2UserService)
                        )
                );

        return http.build();
    }

}