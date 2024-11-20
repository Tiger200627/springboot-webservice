plugins {
	java
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("com.h2database:h2") // H2 인메모리 관계형 데이터베이스(별도 설치 X, JPA 테스트용, 재시작 시 초기화됨)
	implementation("org.springframework.boot:spring-boot-starter-mustache") // 머스테치
	implementation("org.springframework.boot:spring-boot-starter-oauth2-client") // 소셜 로그인 등 소셜 기능 구현 시 필요
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.session:spring-session-jdbc") // 세션 저장소-jdbc (SPRING_SESSION, SPRING_SESSION_ATTRIBUTES 자동 생성)
}

tasks.withType<Test> {
	useJUnitPlatform()
}
