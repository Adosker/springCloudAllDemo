package com.server.provide.web;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.kingbrook.service.HelloService;

@FeignClient("HELLO-SERVICE")
public interface RefactorHelloService extends HelloService {

}
