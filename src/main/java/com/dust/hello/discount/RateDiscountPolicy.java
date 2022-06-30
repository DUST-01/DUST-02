package com.dust.hello.discount;

import com.dust.hello.annotaion.MainDiscountPolicy;
import com.dust.hello.member.Grade;
import com.dust.hello.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary ; @Qualifier("mainDiscountPolicy) 보다 자주 쓰이고 편리
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}