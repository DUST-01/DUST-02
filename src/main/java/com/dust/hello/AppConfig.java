package com.dust.hello;

import com.dust.hello.discount.FixDiscountPolicy;
import com.dust.hello.member.MemberService;
import com.dust.hello.member.MemberServiceImpl;
import com.dust.hello.member.MemoryMemberRepository;
import com.dust.hello.order.OrderService;
import com.dust.hello.order.OrderServiceImpl;

// DIP 위반을 회피하기 위해 구현 객체를 생성
// 생성한 인스턴스의 참조를 생성자를 통해 주입해준다
public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
