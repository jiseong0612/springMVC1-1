package hello.springmvc.basic.request;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RequestParamController {
	@RequestMapping("/request-param-v1")
	public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));

		log.info("username = {}, age = {}", username, age);

		response.getWriter().write("OK~~!!@!@!");
	}

	@ResponseBody
	@RequestMapping("/request-param-v2")
	public String requestParamV2(@RequestParam String username, @RequestParam int age) throws IOException {
		log.info("username = {},, age = {}", username, age);
		return "리스폰스 오케바리~";
	}

	@ResponseBody
	@RequestMapping("/request-param-v3")
	public String requestParamV3(String username, int age) throws IOException {
		// @RequestParam 마저 생략 가능
		log.info("username = {},, age = {}", username, age);
		return "리스폰스 오케바리~";
	}

	@ResponseBody
	@RequestMapping("/request-required")
	public String requestRequired(@RequestParam(required = true) String username, @RequestParam(required = false) Integer age) throws IOException {
		log.info("username = {}, age = {}", username, age);
		return "request-required 오케바리~";
	}
	
	@ResponseBody
	@RequestMapping("/request-required-map")
	public String requestRequiredMap(@RequestParam Map<String, String> map) throws IOException {
		System.out.println(map);
		System.out.println(map.keySet());
		System.out.println(map.values());
		log.info("username = {}, age = {}", map.get("username"), map.get("age"));
		return "request-required 오케바리~";
	}
}
