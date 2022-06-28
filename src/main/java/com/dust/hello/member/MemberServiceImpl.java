package com.dust.hello.member;

public class MemberServiceImpl implements MemberService {
    
    // App Config에서 처리하도록 뺴주기 (배우는 연기만, 섭외는 공연기획자가)
    // MemberServiceImpl은 이제부터 "의존관계에 대한 고민은 외부"에 맡기고 "실행에만 집중"하면 된다.
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
