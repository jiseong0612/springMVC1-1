package hello.springmvc;

import hello.springmvc.core.discount.DiscountPolicy;
import hello.springmvc.core.discount.FixDiscountPolicy;
import hello.springmvc.core.discount.RateDiscountPolicy;
import hello.springmvc.core.repository.MemberRepository;
import hello.springmvc.core.repository.MemoryMemberRepository;
import hello.springmvc.core.service.MemberService;
import hello.springmvc.core.service.MemberServiceImpl;
import hello.springmvc.core.service.OrderService;
import hello.springmvc.core.service.OrderServiceImpl;

public class AppConfig {
	
	//새로운 메서드를 만듦으로써 중복제거 
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	public DiscountPolicy discountPolicy() {
		return new FixDiscountPolicy();
	}
	
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}
	
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	
}
