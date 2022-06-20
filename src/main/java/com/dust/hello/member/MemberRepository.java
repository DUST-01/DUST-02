package com.dust.hello.member;

public interface MemberRepository {

    void save(Member member);       //회원 데이터 저장

    Member findById(Long memberId); //회원 데이터 찾기
}
