package com.dust.hello.discount;

import com.dust.hello.annotation.MainDiscountPolicy;
import com.dust.hello.member.Grade;
import com.dust.hello.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@MainDiscountPolicy 요런식으로 사용자지정 어노테이션으로 가능하다!
@Component
@Primary
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP){
            return price*discountPercent/100;
        }else{
            return 0;
        }
    }
}
