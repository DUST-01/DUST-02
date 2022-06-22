package com.dust.hello.order;

import com.dust.hello.AppConfig;
import com.dust.hello.member.Grade;
import com.dust.hello.member.Member;
import com.dust.hello.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    //MemberService memberService = new MemberServiceImpl();
    //OrderService orderService = new OrderServiceImpl();

    // 의존성 제거
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }


     @Test
    void createOrder() {
         Long memberId = 1L;
         Member member = new Member(memberId, "memberA", Grade.VIP);
         memberService.join(member);

         Order order = orderService.createOrder(memberId, "itemA", 20000);
         Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);
     }
}
