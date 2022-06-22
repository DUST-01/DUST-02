package com.dust.hello.discount;

import com.dust.hello.member.Grade;
import com.dust.hello.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        // enum type은 .equals() 대신 "==" 비교연산자가 맞음음
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
