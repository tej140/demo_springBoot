package com.npci;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

	@RequestMapping("/hi")
	public String hello() {
		return "Hello EveryOne, You are in REST";
	}
	
}



