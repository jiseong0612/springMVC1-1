package hello.springmvc.basic.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RequsetHeaderController {
	@RequestMapping("/headers")
	public String headers(HttpServletRequest request,HttpServletResponse response) {
		return null;
	}
}
