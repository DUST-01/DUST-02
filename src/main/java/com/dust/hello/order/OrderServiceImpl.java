package com.dust.hello.order;

import com.dust.hello.discount.DiscountPolicy;
import com.dust.hello.discount.FixDiscountPolicy;
import com.dust.hello.discount.RateDiscountPolicy;
import com.dust.hello.member.Member;
import com.dust.hello.member.MemberRepository;
import com.dust.hello.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private MemberRepository memberRepository;
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //이부분이 dip를 위반한 부분디ㅏ. 고치는순간 ocp 위반
    private DiscountPolicy discountPolicy;  //와 오지네 이렇게 변경하면 dip와 ocp를 없앤다. 
    //단 무조건 의존성 주입을 해주어야 한다!

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
