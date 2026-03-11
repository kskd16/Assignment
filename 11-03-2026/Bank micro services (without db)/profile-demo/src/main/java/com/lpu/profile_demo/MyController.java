package com.lpu.profile_demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/dev")
@RestController
//@Profile("dev")
public class MyController {
	
	@Value("${server.port}")
	private String port;
	@Value("${user.name2}")
	private String name;
	
	@GetMapping("/hii")
	public String getHI() {
		return name+"  "+port;
	}

}
