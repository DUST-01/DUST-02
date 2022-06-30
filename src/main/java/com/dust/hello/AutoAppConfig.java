package com.dust.hello;

import com.dust.hello.member.MemberRepository;
import com.dust.hello.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //탐색 시작위치를 지정, 지정하지 않으면 @ComponentScan이 붙은 설정 정보 클래스의 패키지가 시작위치가 된다.
        //권장) 패키지 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 것
//        basePackages = "com.dust.hello.member",

        //AppConfig, TestConfig는 자동스캔 대상에서 제외하기 위한 설정
        excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    @Bean(name="memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
        //이 경우 수동 빈이 우선권을 갖는다(수동 빈이 자동 빈을 오버라이딩 해버린다.)
        //그러면 정말 잡기 어려운 버그가 만들어진다.
        //그래서 최근 스프링 부트에서는 수동 빈 등록과 자동 빈 등록이 충돌나면 오류가 발생하도록 기본 값을 바꾸었다.
    }

}
