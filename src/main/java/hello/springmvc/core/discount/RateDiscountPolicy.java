package hello.springmvc.core.discount;

import org.springframework.stereotype.Component;

import hello.springmvc.core.domain.Grade;
import hello.springmvc.core.domain.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy {
	private final int discountPercent = 10;

	@Override
	public int discount(Member member, int price) {

		if (member.getGrade() == Grade.VIP) {
			return price * discountPercent / 100;
		} else {
			return 0;
		}

	}

}
