package com.dust.hello.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given - 주어진 환경
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when - 진행했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then - 결과
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
