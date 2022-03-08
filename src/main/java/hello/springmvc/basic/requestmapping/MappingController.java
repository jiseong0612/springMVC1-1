package hello.springmvc.basic.requestmapping;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
