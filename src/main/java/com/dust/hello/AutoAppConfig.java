package com.dust.hello;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // 보통 @Configuration 필터하지 않음
//        basePackages = "com.dust.hello",
//        basePackageClasses = AutoAppConfig.class, 두 가지를 설정하지 않으면 ComponentScan이 붙은 위치에서 검색
//        관례로 main Application 위치에 @ComponentScan을 둔다
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
