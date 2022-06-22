package com.dust.hello.member;

public class MemberServiceImpl implements MemberService {

    /*@Override 에 의해 MemberRepository 에 있는 메서드가 아닌 MemoryMemberRepository 의 메서드가 호출됨*/
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
