package com.kingbrook.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kingbrook.web.aspect.ServiceLog;
import com.kingbrook.web.jdbc.mapper.UserMapper;
import com.kingbrook.web.jdbc.po.User;
import com.kingbrook.web.jdbc.service.UserService;
/**
 * 创建一个RESTful API的实现代码    同SpringMVC一样  但是不需要像SpringMVC写太多配置   直接从Controller开始
 * @author Administrator
 *
 */
@RestController
public class HelloController {
	@Autowired
	private UserService userService;
	@RequestMapping("/hello")
	public String index() {
		long beginTime=System.currentTimeMillis();
		User  user = userService.selectByPrimaryKey(1);
        long time=System.currentTimeMillis()-beginTime;
		return "Hello SpringBoot"+user.getName()+",消耗查询时间："+time;
		
	}
	
	
}
