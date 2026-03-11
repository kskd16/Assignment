package com.lpu.deposit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/deposit")
@RestController
public class DepositController {
	
	@GetMapping("/save")
	public String save() {
		return "deposit transaction executed";
	}
	

}
