package hello.springmvc.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import hello.springmvc.core.domain.Grade;
import hello.springmvc.core.domain.Member;
import hello.springmvc.core.domain.Order;
import hello.springmvc.core.repository.MemoryMemberRepository;
import hello.springmvc.core.service.MemberService;
import hello.springmvc.core.service.MemberServiceImpl;
import hello.springmvc.core.service.OrderService;
import hello.springmvc.core.service.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderAPPTests {
	@Autowired
	private MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
	@Autowired
	private OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());

	@Test
	public void test() {
		System.out.println(memberService);
		System.out.println(orderService);
	}

	@Test
	public void createOrder() {

		// 회원가입
		Member memberA = new Member(1L, "memberA", Grade.VIP);
		memberService.join(memberA);
		// 조회 및 검사
		Member findMember = memberService.findMember(memberA.getId());
		Assertions.assertThat(memberA.getId()).isEqualTo(findMember.getId());

		Order order = orderService.createOrder(findMember.getId(), "itemA", 100);

		log.info("order = {}", order);
	}

}
