package com.dust.hello.order;

import com.dust.hello.discount.DiscountPolicy;
import com.dust.hello.discount.FixDiscountPolicy;
import com.dust.hello.member.Member;
import com.dust.hello.member.MemberRepository;
import com.dust.hello.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
