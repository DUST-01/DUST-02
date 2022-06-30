package com.dust.hello.scan;

import com.dust.hello.AutoAppConfig;
import com.dust.hello.member.MemberRepository;
import com.dust.hello.member.MemberService;
import com.dust.hello.member.MemberServiceImpl;
import com.dust.hello.order.OrderService;
import com.dust.hello.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

    }
}
