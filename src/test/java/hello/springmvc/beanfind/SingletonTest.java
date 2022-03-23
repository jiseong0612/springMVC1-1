package hello.springmvc.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.springmvc.AppConfig;
import hello.springmvc.core.service.MemberService;

public class SingletonTest {
	
	@Test
	@DisplayName("순수 자바 DI컨테이너")
	public void appConfigTest() {
		AppConfig ap = new AppConfig();
		
		MemberService memberService1 = ap.memberService();
		MemberService memberService2 = ap.memberService();
		
		System.out.println(memberService1);
		System.out.println(memberService2);
		
		//hello.springmvc.core.service.MemberServiceImpl@6989da5e  다른 객체임을 확인할 수 있다.
		//hello.springmvc.core.service.MemberServiceImpl@385c9627
	}
	
	@Test
	@DisplayName("스프링 DI컨테이너")
	public void springContainerTest() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService1 = ac.getBean(MemberService.class);
		MemberService memberService2 = ac.getBean(MemberService.class);
		
		System.out.println(memberService1);
		System.out.println(memberService2);
		
		//hello.springmvc.core.service.MemberServiceImpl@d3957fe @Configuration 어노테이션을 사용함으로 싱긅론을 보장받는다.
		//hello.springmvc.core.service.MemberServiceImpl@d3957fe
	}
}
