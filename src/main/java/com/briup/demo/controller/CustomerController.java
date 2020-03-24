package com.briup.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Customer;
import com.briup.demo.mapper.ex.CustomerDao;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "用户相关接口")
public class CustomerController {
	
	@Autowired
	private CustomerDao customerDao;
	
	@PostMapping("/addCustomer")
	@ApiOperation("添加用户")
	public Message<Customer> addCustomer(Customer customer){
		return MessageUtil.success(customerDao.save(customer));
	}

}
