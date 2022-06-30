package com.dust.hello.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component //memoryMemberRepository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // 동시성이슈로 실무에서는 컨커런트해시맵을 써야함

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
