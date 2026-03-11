package com.lpu.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/account")
@RestController
public class AccountController {
	
	@GetMapping("/save")
	public String save() {
		return "Account saved!!";
	}

}
