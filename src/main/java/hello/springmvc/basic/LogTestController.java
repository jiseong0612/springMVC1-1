package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@RestController
public class LogTestController {
	//private final Logger log = LoggerFactory.getLogger(getClass());
	// 또는 private final Logger log = LoggerFactory.getLogger(LogTestController.class);
	
	
	@GetMapping("/log-test")
	public String logTest() {
		String name = "spring";
		
		System.out.println("name = " + name);
		log.debug("debug log ={}", name);
		log.info(" info log = {}", name);
		log.warn(" info log = {}", name);
		log.error(" info log = {}", name);
		log.info(name)
		return "OK";
	}
}
