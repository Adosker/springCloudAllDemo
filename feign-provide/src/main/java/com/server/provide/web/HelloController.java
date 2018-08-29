package com.server.provide.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String hello() {
		return "hello provide";
	}
	
	@RequestMapping("/hello1")
	public String hello(@RequestParam String name) {
		return "Hello "+name;
	}
	
	@RequestMapping("/hello2")
	public User hello(@RequestHeader String name,@RequestHeader Integer age) {
		return new User(name,age);
	}
	
	@RequestMapping("/hello3")
	public String hello(@RequestBody User user) {
		return "Hello "+user.getName()+","+user.getAge();
	}
}
