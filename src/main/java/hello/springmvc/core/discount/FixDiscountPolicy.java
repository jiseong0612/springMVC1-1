package hello.springmvc.core.discount;

import org.springframework.stereotype.Component;

import hello.springmvc.core.domain.Grade;
import hello.springmvc.core.domain.Member;

@Component
public class FixDiscountPolicy implements DiscountPolicy {
	private int discountFixAmount = 1000;

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		} else {
			return 0;
		}
	}

}
