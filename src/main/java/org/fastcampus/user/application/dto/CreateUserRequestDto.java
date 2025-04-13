package org.fastcampus.user.application.dto;

//record 권장
//자바 14부터 지원
//final 불변변수 + getter 로만 구성
public record CreateUserRequestDto(String name, String profileImageUrl) {
}
