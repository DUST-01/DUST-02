package com.dust.hello;

import com.dust.hello.discount.DiscountPolicy;
import com.dust.hello.discount.FixDiscountPolicy;
import com.dust.hello.discount.RateDiscountPolicy;
import com.dust.hello.member.MemberService;
import com.dust.hello.member.MemberServiceImpl;
import com.dust.hello.member.MemoryMemberRepository;
import com.dust.hello.order.OrderService;
import com.dust.hello.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // 리팩토링 후 역할과 구현 분리
    // 유지보수 시, 무엇을 바꿔야 할지 한눈에 알 수 있음.
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
