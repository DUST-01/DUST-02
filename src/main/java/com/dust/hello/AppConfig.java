package com.dust.hello;

import com.dust.hello.discount.DiscountPolicy;
import com.dust.hello.discount.FixDiscountPolicy;
import com.dust.hello.discount.RateDiscountPolicy;
import com.dust.hello.member.MemberRepository;
import com.dust.hello.member.MemberService;
import com.dust.hello.member.MemberServiceImpl;
import com.dust.hello.member.MemoryMemberRepository;
import com.dust.hello.order.OrderService;
import com.dust.hello.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }


}
