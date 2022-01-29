package hello.core.discount;

import hello.core.Order.Order;
import hello.core.Order.OrderServiceImpl;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    //given
    RateDiscountPolicy policy = new RateDiscountPolicy();
    OrderServiceImpl orderService = new OrderServiceImpl();



    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o (){

        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = policy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);


    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x(){

        //given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);

        //when
        int discount = policy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);

    }
}