package hello.springmvc.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.springmvc.AppConfig;
import hello.springmvc.core.domain.Grade;
import hello.springmvc.core.domain.Member;
import hello.springmvc.core.domain.Order;
import hello.springmvc.core.service.MemberService;
import hello.springmvc.core.service.OrderService;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class OrderAPPTests {
	MemberService memberService;
	OrderService orderService;
	
	//테스트 전 모든 메서드에 할당한다.
	@BeforeEach
	public void beforeEach() {
		// 자바 기반 DI 컨테이너 사용
//		AppConfig ap = new AppConfig();
//		memberService = ap.memberService();
//		orderService = ap.orderService();
		
		//스프링 기반 스프링 컨테이너 사용
		ApplicationContext ap = new AnnotationConfigApplicationContext(AppConfig.class);
		memberService = ap.getBean("memberService", MemberService.class);
		orderService = ap.getBean("orderService", OrderService.class);
	}
	
	@Test
	public void createOrder() {
		
		//회원가입
		Member memberA = new Member(1L, "memberA", Grade.VIP);
		memberService.join(memberA);
		//조회 및 검사
		Member findMember = memberService.findMember(memberA.getId());
		Assertions.assertThat(memberA.getId()).isEqualTo(findMember.getId());
		
		Order order = orderService.createOrder(findMember.getId(), "itemA", 100);
		
		log.info("order = {}", order);
	}

}
