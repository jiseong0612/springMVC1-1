package hello.springmvc.core.service;

import hello.springmvc.core.discount.DiscountPolicy;
import hello.springmvc.core.domain.Member;
import hello.springmvc.core.domain.Order;
import hello.springmvc.core.repository.MemberRepository;

public class OrderServiceImpl implements OrderService{
	
	private final MemberRepository memberRepository;
	private  final DiscountPolicy discountPolicy;
	
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		// 단일 책임 법칙을 잘 지킨것이.... 할인금액? createOrder() ="난 몰라?, 'discountPolicy' 니가 알아서 해줘"
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

}
