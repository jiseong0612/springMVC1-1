package hello.springmvc.beanfind;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.springmvc.AutoAppConfig;
import hello.springmvc.core.discount.DiscountPolicy;
import hello.springmvc.core.service.MemberService;

public class AutoAppConfigBeanTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

	@Test
	@DisplayName("모든 빈 출력하기")
	public void findAllBean() {
		String[] beanNames = ac.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			Object bean = ac.getBean(beanName);
			System.out.println(beanName + " = " + bean);
		}
	}

	@Test
	@DisplayName("애플리케이션 빈 출력하기")
	public void findAppBean() {
		String[] beanNames = ac.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanName);

			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				Object bean = ac.getBean(beanName);
				System.out.println(beanName + " = " + bean);
			}
		}
	}

	@Test
	@DisplayName("특정 타입 모두 조회하기")
	public void findAllBeanByType() {
		Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
		System.out.println(beansOfType);
	}

	@Test
	void basicScan() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		MemberService memberService = ac.getBean(MemberService.class);
		assertThat(memberService).isInstanceOf(MemberService.class);
	}

}