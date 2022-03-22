package hello.springmvc.core.discount;

import hello.springmvc.core.domain.Member;

public interface DiscountPolicy {
	int discount(Member member, int price);
}
