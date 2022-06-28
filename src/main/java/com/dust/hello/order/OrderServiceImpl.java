package com.dust.hello.order;

import com.dust.hello.discount.DiscountPolicy;
import com.dust.hello.member.Member;
import com.dust.hello.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    // App Config에서 처리하도록 뺴주기 (배우는 연기만, 섭외는 공연기획자가)
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
