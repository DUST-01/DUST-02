package com.dust.hello.member;

public interface MemberService {

    void join(Member member);           //회원 등록
    Member findMember(Long memberId);   //회원 찾기


}
