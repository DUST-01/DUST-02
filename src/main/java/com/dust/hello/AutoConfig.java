package com.dust.hello;

import com.dust.hello.member.MemberRepository;
import com.dust.hello.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(
        basePackages = "com.dust.hello.member",
        basePackageClasses = AutoConfig.class, //지정하지 않을경우 해당 컴포넌트 스캔이 있는 위치가 지정위치가 된다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoConfig {

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository (){
//        return new MemoryMemberRepository();
//    }
}
