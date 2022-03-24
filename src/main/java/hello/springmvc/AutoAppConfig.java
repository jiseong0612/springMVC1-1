package hello.springmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AutoAppConfig {
	private int age= 10;

	private int getAge() {
		return age;
	}

	private void setAge(int age) {
		this.age = age;
	}
	
}
