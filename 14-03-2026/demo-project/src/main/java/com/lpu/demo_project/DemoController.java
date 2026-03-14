package com.lpu.demo_project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo")
@RestController
public class DemoController {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@PostMapping("/save")
	public String save(@RequestBody Student student) {
		
		logger.info("student came to save method  with Id : "+student.getId());
		if(student.getName()== null) {
			logger.error("Student Name should not be null");
			throw new RuntimeException("Student name is null");
		}
		
		logger.debug("Student saved with id: "+ student.getId());
		return "saved";
	}

}
