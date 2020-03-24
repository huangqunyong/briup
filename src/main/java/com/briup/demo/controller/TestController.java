package com.briup.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@SuppressWarnings("unused")
@RestController
@Api(description = "测试接口")
public class TestController {
	
	@GetMapping("/")//等同于@RequestMapping(value = "/",method = RequestMethod.GET)
	@ApiOperation("测试")
	public String test() {
		return "测试";
	}
	
}
