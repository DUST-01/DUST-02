package com.dust.hello.discount;

import com.dust.hello.annotation.MainDiscountPolicy;
import com.dust.hello.member.Grade;
import com.dust.hello.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
@Primary
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountRateAmount = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountRateAmount / 100;
        } else {
            return 0;
        }
    }
}
