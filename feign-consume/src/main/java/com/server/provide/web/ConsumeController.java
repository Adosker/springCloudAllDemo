package com.server.provide.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumeController {
	
	@Autowired
	HelloService helloService;
	@Autowired
	RefactorHelloService refactorHelloService;
	
	@RequestMapping(value="/feign-consumer",method=RequestMethod.GET)
	public String helloConsumer(){
		return helloService.hello();
	}
	
	@RequestMapping(value="/feign-consumer2",method=RequestMethod.GET)
	public String helloConsumer2(){
		StringBuilder sb = new StringBuilder();
		sb.append(helloService.hello()).append("\n");
		sb.append(helloService.hello("LULU")).append("\n");
		sb.append(helloService.hello("LULU",18)).append("\n");
		sb.append(helloService.hello(new User("LULU",18))).append("\n");
		return sb.toString();
	}
	
	@RequestMapping(value="/feign-consumer3",method=RequestMethod.GET)
	public String helloConsumer3(){
		StringBuilder sb = new StringBuilder();
		sb.append(refactorHelloService.hello("KINGKANG")).append("\n");
		sb.append(refactorHelloService.hello("KINGKANG",18)).append("\n");
		sb.append(refactorHelloService.hello(new com.kingbrook.dto.User("KINGKANG",18))).append("\n");
		return sb.toString();
	}
}
