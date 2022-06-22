package com.dust.hello.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    /*동시성 문제로 실무에서는 HashMap 대신 ConcurrentHashMap 을 사용
    * ConcurrentHashMap - key value 에 null 을 허용하지 않음, 동기화를 보장*/
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
