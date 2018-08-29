package com.server.provide.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kingbrook.dto.User;
import com.kingbrook.service.HelloService;
//当时没写
@RestController
public class RefactorHelloController implements HelloService {
	@Override
	public String hello(@RequestParam("name") String name) {
		return "Hello "+name;
	}
	//注解后面必须要有参数
	@Override
	public User hello(@RequestHeader("name") String name,@RequestHeader("age") Integer age) {
		return new User(name,age);
	}
	@Override
	public String hello(@RequestBody User user) {
		return "Hello "+user.getName()+","+user.getAge();
	}

}
