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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 중요
// AppCongig는 애플리케이션의 실제 동작에 필요한 "구현 객체를 생성"한다.
// App Config는 생성한 객체 인스턴스의 참조(레퍼런스)를 "생성자를 통해서 주입(연결)"해준다.
@Configuration
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // 할인 정책 변경 시, 애플리케이션의 구성 역할을 담당하는 AppConfig만 변경하면 됨 (사용영역 코드수정 불필요)
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
 
}




