package hello.springmvc.basic.requestmapping;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MappingController {

	@GetMapping("/hello-basic")
	public String helloBasic() {
		log.info("helloBasic");
		return "OK~~~";
	}
	
	@GetMapping("/mapping/{userId}")
	public String  mappingPath(@PathVariable String userId) {
		log.info("data = {}", userId);
		return userId;
	}
	
	@GetMapping("/mapping/{userId}/orderes/{orderId}")
	public String  mappingPath(@PathVariable String userId, @PathVariable String orderId) {
		log.info("data = {}, orderId = {}", userId, orderId);
		return userId + ", "+ orderId;
	}
	
	//서버가 소비하는 입장이다. 따라서 consumes
	@PostMapping(value = "/mapping-consume", consumes = "application/json", produces = "text/pain")
	public String mappingConsume() {
		log.info("mappingConsume");
		return "OK~!";
	}
	
	//서버가 리턴해주는 즉 생산하는 값의 타입 produces, 헤더의 Accept를 맞춰줘야함
	@PostMapping(value = "/mapping-produces", produces = "text/pain")
	public String mappingProduces() {
		log.info("mappingProduces");
		return "OK~!";
	}
}
